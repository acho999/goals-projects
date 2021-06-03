public class BitMasking {
    public static final int POWER = 1<<2,PAPER = 1<<1,TONER= 1 << 0 ;//all in once declaration

    public static void main(String[] args){



        int a = 0b100;//binary number in decimal it is 4
        System.out.println(a);//this will print 4


        int b = 10;
        System.out.println(Integer.toBinaryString(b));//that is how we will print 10 to binary -> 1010

        int status = 0b011;//after b first bit is power, second is paper, third is toner

        int paperMask = 1 << 1; //0b001 = 1 then we move bits left with 1 position and it becomes 010
        //which means we have paer because we have 1

        //check if we have paper
        /*
        * status & paperMask = 011 & 010 -> 010 which is paper mask which is 2
        *
        * check if we have not paper
        *
        * staus & paperMask = 001 & 010 -> 000 which is 0*/

        int result = status & paperMask;

        if (result == paperMask || result != 0){
            System.out.println("there is a paper");
        }

        //we want to turn printer on as move most right bit 2 positions left to make first 0 to be 1

        int powerMask = 1 << 2; //001 -> 100

        //then we XOR with the status 011 ^ 100 -> 111 = 7
        //if we want to switch off printer we again XOR 111 ^ 100 -> 011 = 3

        status = status ^ powerMask;
        System.out.println("printer is on " + Integer.toBinaryString(status));

        status = status ^ powerMask;
        System.out.println("printer is off " + Integer.toBinaryString(status));

        //if we want to printer stay turned on we can use OR "|"
        //011 | 100 = 111 and if we again make 111 | 100 = 111 and printer stay on
        status = status | powerMask;
        System.out.println("printer is on " + Integer.toBinaryString(status));

        //here again status is 111
        status = status | powerMask;
        System.out.println("printer is on " + Integer.toBinaryString(status));

        //if we want to stop printer we have to revert powerMask
        int invertPowerMask = ~powerMask;
        System.out.println("printer is off " + Integer.toBinaryString(invertPowerMask));
        //this will print 11111111111111111111111111111011 because all 0-s are reverted in to 1 and int is 32 bit number

        //we want do make printer off and if we re do operation ti will stay off
        status = status & invertPowerMask;//111 & 011 => 011
        System.out.println("printer is off " + Integer.toBinaryString(status));
    }

}
