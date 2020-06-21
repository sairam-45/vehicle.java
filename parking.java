
package s4970;

import java.util.Date;
import java.util.Scanner;
class vehicleData{
     vehicleData(int N_Slots, int[]  V_type,int[]  regno,int[] N_days, int[] Time,int[] Amount,int s,int z){
         System.out.println("\n");

         Date date=new Date();
         System.out.print("\t\t\t\tDate And Time Of Parking Vehicle:-"+ date.toString());
         System.out.println("\n");
         System.out.print("\t\t\t\tNumber of vehicles..."+N_Slots);


        System.out.println("\n");
        System.out.print("\t\t\t\tThe Slot Number of the vehicle is.."+z);
        System.out.println("\n");
        switch (V_type[z]) {
            case 1:
                System.out.print("\t\t\t\tThe Vehicle type is Bike");
                break;
            case 2:
                System.out.print("\t\t\t\tThe Vehicle type is Auto");
                break;
            case 3:
                System.out.print("\t\t\t\tThe Vehicle type is Car");
                break;
            default:
                break;
        }
        System.out.println("\n");
        System.out.print("\t\t\t\tThe Vehicle registration number is.."+regno[z]);
        if(N_days[z]!=0)
        {
            System.out.println("\n");
            System.out.print("\t\t\t\tThe Number of days used for parking are.."+N_days[z]);
        }
        else
        {
            System.out.println("\n");
            System.out.print("\t\t\t\tThe time of parking is.."+Time[z]+"hrs");
        }
        System.out.println("\n");

        System.out.print("\t\t\t\tThe Total Amount is...$"+Amount[z]);
    }
}
class ownerData{
    ownerData(String[] oname,String[] mail,int[] mob,String[] address,int z){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\t\t\t\tOwner Name..."+oname[z]);
        System.out.println("\n");
        System.out.print("\t\t\t\tMail-id......."+mail[z]);
        System.out.println("\n");
        System.out.print("\t\t\t\tMobile number....."+mob[z]);
        System.out.println("\n");
        System.out.print("\t\t\t\tAddress......."+address[z]);

    }
}
class InvalidSlotException extends Exception{
    InvalidSlotException(int[] V_type){
        System.out.println("Slot Cannot Be Applied For The Type You Have Entered");
    }
}

class vehicleparking{
    vehicleparking(int M_Slots){
        System.out.println("__________________________________________________________________________________________________________________________________________");
        System.out.println("\t\t\t\tNo. Of Unassigned Vehicles Are....."+M_Slots);

    }
}

class SlotNotFoundException extends Exception{
    SlotNotFoundException(){
        System.out.println("Slot entered did not found");
    }
}
class ParkingManagementSystem {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        System.out.println("\t\t**************************************\t\t");
        System.out.println("\t\t***************PVR Multiplex**********\t\t");
        System.out.println("\t\t**************************************\t\t\n\n");
        System.out.println("\tPrices for Different types of Vehicles are as follows:");
        System.out.println("\t-----------------------------------------------------\n");
        System.out.println("\t Bikes or Any other 2 wheeler\t |\t $50/hr \t|\t $100/day\n");
        System.out.println("\t Auto or Any other 3 wheeler \t |\t $80/hr \t|\t $120/day\n");
        System.out.println("\t Car or Any other 4 wheeler  \t |\t $100/hr\t|\t $200/day\n");
        System.out.println("\n");
        int count=1;
        int N_Slots,M_Slots;
        System.out.println("\t\t\t\tEnter Number of slots");
        N_Slots = k.nextInt();
        //int[] M_Slots;
        //M_Slots=new int[20];
        String[] oname;
        oname = new String[20];
        String[] mail;
        mail = new String[20];
        String[] address;
        address = new String[20];
        int[] mob;
        mob = new int[20];
        int[] V_type;
        V_type = new int[20];
        int[] regno;
        regno = new int[20];
        int[] N_days;
        N_days = new int[20];
        int[] Time;
        Time = new int[20];
        int[] Amount;
        Amount = new int[20];
        for (int i = 1; i <= N_Slots; i++,count++) {
            System.out.println("\n");
            System.out.println("\t\t\t\tEnter the vehicle type\n 1. For Bike\n 2. For Truck\n 3. For Car");
            V_type[i] = k.nextInt();
            if ((V_type[i] != 1) && (V_type[i] != 2) && (V_type[i] != 3)) {
                InvalidSlotException s=new InvalidSlotException(V_type);

            } else {
                System.out.println("\n");
                System.out.println("\t\t\t\t----Please wait-----");
//owner details
                System.out.println("\t\t\t\tEnter owner Name");
                oname[i] = k.next();
                System.out.println("\n");


                System.out.println("\t\t\t\tMobile number please");
                mob[i] = k.nextInt();
                System.out.println("\n");


                System.out.println("\t\t\t\tMail-Id");
                mail[i] = k.next();
                System.out.println("\n");

                System.out.println("\t\t\t\tOwner Address");
                address[i] = k.next();
                System.out.println("\n");


//vehicle details

                System.out.println("\t\t\t\tEnter the registration number");
                regno[i] = k.nextInt();
                System.out.println("\n");


                System.out.println("\t\t\t\tEnter number of days for parking");
                N_days[i] = k.nextInt();
                System.out.println("\n");


                if (V_type[i] == 1) {
                    if (N_days[i] == 0) {
                        System.out.println("\n");
                        System.out.println("\t\t\t\tEnter the parking time on hourly bases");
                        Time[i] = k.nextInt();
                        Amount[i] = 50 * Time[i];
                    } else {
                        Amount[i] = 100 * N_days[i];
                    }
                }
                if (V_type[i] == 2) {
                    if (N_days[i] == 0) {
                        System.out.println("\n");
                        System.out.println("\t\t\t\tEnter the parking time on hourly bases");
                        Time[i] = k.nextInt();
                        Amount[i] = 80 * Time[i];
                    } else {
                        Amount[i] = 120 * N_days[i];
                    }
                }
                if (V_type[i] == 3) {
                    if (N_days[i] == 0) {
                        System.out.println("\n");
                        System.out.println("\t\t\t\tEnter the parking time on hourly bases");
                        Time[i] = k.nextInt();
                        Amount[i] = 100 * Time[i];
                    } else {
                        Amount[i] = 200 * N_days[i];
                    }
                }
            }
            M_Slots=N_Slots-count;
            vehicleparking v=new vehicleparking(M_Slots);


        }

        System.out.println("\n\n");
        System.out.println("\t\t\t\tEnter the registration number of vehicle to be searched and to know the billibg details");
        int s;
        s=k.nextInt();
        int z=0;
        for(int i=1;i<=N_Slots;i++){
            if(s==regno[i]){
                z=i;
            }
            else
            {
                SlotNotFoundException q=new SlotNotFoundException();
            }
        }
        ownerData o=new ownerData(oname,mail,mob,address,z);
        vehicleData d=new vehicleData(N_Slots,V_type,regno,N_days,Time,Amount,s,z);
    }
}
