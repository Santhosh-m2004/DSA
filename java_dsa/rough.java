import java.util.Scanner; 
public class rough { 
public static void main(String[] args) { 
Scanner scanner = new Scanner(System.in); 
// Input the window size 
System.out.print("Enter Window Size: "); 
int windowSize = scanner.nextInt(); 
// Input the number of frames to transmit 
System.out.print("\nEnter number of frames to transmit: "); 
int frameCount = scanner.nextInt(); 
// Input the frames 
int[] frames = new int[frameCount]; 
System.out.println("\nEnter the " + frameCount + " frames:"); 
for (int i = 0; i < frameCount; i++) { 
frames[i] = scanner.nextInt(); 
} 
// Transmit frames and simulate acknowledgment 
for (int i = 0; i < frameCount; i++) { 
System.out.println("Frame " + frames[i] + " sent."); 
// Check if window is full, then send acknowledgment 
if ((i + 1) % windowSize == 0) { 
System.out.println("Acknowledgment of above frames received by sender\n"); 
} 
} 
// If there are remaining frames after the last full window, send acknowledgment 
if (frameCount % windowSize != 0) { 
System.out.println("Acknowledgment of above frames received by sender\n"); 
} 
scanner.close(); 
} 
}