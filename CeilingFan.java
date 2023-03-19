import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CeilingFan {
    private int speed;
    private boolean direction;


    public CeilingFan() {
        speed = 0;
        direction = false;

    }

    public void pullSpeedCord() { // To get the Speed of the Ceiling Fan
        speed++;
        if (speed > 3) {
            speed = 0;
        }
        System.out.println("Speed set to " + speed);
        if (speed==0) {
        System.out.println("Fan is switched OFF");
        }else if(speed==1){
            System.out.println("Fan is in lower speed");
        }else if (speed==2){
            System.out.println("Fan is in Medium Speed");
        } else{
            System.out.println("Fan is in High Speed");
        }
    }

    public void pullDirectionCord() { // To get the direction of the Ceiling Fan
        direction = !direction;
        System.out.println("Direction set to " + (direction ? "clockwise" : "counterclockwise"));
    }

    public boolean returnDate() { //If the date is Dec 25 of any year, It returns true and the speed of the fan will be set to 0 which means Switch off

        Date date = new Date();
        SimpleDateFormat formats = new SimpleDateFormat("MM/dd");
        String formattedDate = formats.format(date);
        String switchOffDate = "12/25";

        if (formattedDate.equals(switchOffDate)) {
            System.out.println("your ceiling fan will be off today");
            return true;
        }

       return false;
    }

    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        CeilingFan fan = new CeilingFan();

        while (true) {  // To loop till the user hits Quit 
            System.out.println("1 - Pull speed cord");
            System.out.println("2 - Pull direction cord");
            System.out.println("3 - Quit");

            int choice = scanner.nextInt();

             if (fan.returnDate()) { // Only works when local date of the machine is not Dec 25th of any year
                fan.speed = 0;
            }


            switch (choice) { // To choose between 3 options 1 - pull speed cord, 2 - Pull Direction Cord, 3 - Quit
                case 1:
                    fan.pullSpeedCord();
                    break;
                case 2:
                    fan.pullDirectionCord();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }

            System.out.println();
        }
    }
}
