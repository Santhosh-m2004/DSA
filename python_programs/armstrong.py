import threading
import requests
from bs4 import BeautifulSoup
from queue import Queue
import time

# List of URLs to scrape
urls = [
    "https://www.python.org",
    "https://www.djangoproject.com",
    "https://flask.palletsprojects.com/",
    "https://fastapi.tiangolo.com/",
    "https://www.djangoproject.com/community/",
]

# A thread-safe queue to store URLs
url_queue = Queue()

# Lock for thread-safe printing
print_lock = threading.Lock()

def fetch_url(url):
    """Fetches the HTML content of a given URL."""
    try:
        response = requests.get(url, timeout=5)
        response.raise_for_status()  # Raise HTTPError for bad responses
        return response.text
    except requests.RequestException as e:
        with print_lock:
            print(f"Error fetching {url}: {e}")
        return None

def scrape_title(url):
    """Scrapes and prints the title of the web page."""
    html = fetch_url(url)
    if html:
        soup = BeautifulSoup(html, 'html.parser')
        title = soup.title.string if soup.title else "No Title Found"
        with print_lock:
            print(f"Title for {url}: {title}")

def worker():
    """Worker function to process URLs from the queue."""
    while not url_queue.empty():
        url = url_queue.get()
        scrape_title(url)
        url_queue.task_done()

def main():
    """Main function to manage threading and scraping."""
    # Populate the queue with URLs
    for url in urls:
        url_queue.put(url)

    # Create and start threads
    num_threads = 5
    threads = []
    for _ in range(num_threads):
        thread = threading.Thread(target=worker)
        thread.start()
        threads.append(thread)

    # Wait for all tasks to be completed
    url_queue.join()

    # Ensure all threads finish execution
    for thread in threads:
        thread.join()

if __name__ == "__main__":
    start_time = time.time()
    main()
    end_time = time.time()
    print(f"Scraping completed in {end_time - start_time:.2f} seconds.")
