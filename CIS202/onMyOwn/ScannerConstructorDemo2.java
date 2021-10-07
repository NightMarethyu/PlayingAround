import java.util.Scanner;

class ScannerConstructorDemo2
{
    public static void main(String arg[])
    {
        String str = "Germany are the champions\nThis is a new line";
                
        Scanner sc = new Scanner(str);       // LINE A
        
        // Check if sc has another token in the string
        while(sc.hasNextLine()) {
            /* int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(x);
            System.out.println(y);
            xp[i] = x;
            yp[i] = y; */
        }
            System.out.println(sc.next());
        
        // Close the scanner
        sc.close();    
    }
}