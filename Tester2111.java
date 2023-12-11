package tester2111;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
public class Tester2111 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = 0;
        boolean success = false;
        String [] user = new String[1000];
        String [] password = new String[1000];
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\usernames.csv"));
            BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\passwords.csv"));
            String line = "";
            int i = 0,j = 0;
            while((line = br.readLine())!= null){
                user[i] = line;
                i++;
                N++;
            }
            while((line = br2.readLine())!= null){
                password[j] = line;
                j++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        while(true){
        System.out.print("Are you an existing user? Yes - 1. No - 2, Exit - 3: ");
        int exist = input.nextInt();
        if (exist == 1){
            userdefine:
            while(true){
            System.out.print("Please enter username: ");
            String username = input.next();
            System.out.println(" ");
            
            boolean loop1 = true;
            int i;
            
            for(i = 0;i<=N;i++){
                if(username.equals(user[i])){
                    System.out.print("Please enter password: ");
                    String pass_word = input.next();
                    System.out.println(" ");
                    if(pass_word.equals(password[i])){
                        success = true;
                        break userdefine;
                    }else{
                        System.out.println("Password incorrect");
                        break;
                    }
                }
            }
            if(i == N+1){
                System.out.println("User not exist");
            }
        }
        }
        else if(exist == 2){ //add new user
            System.out.print("Please enter new username(no spaces between): ");
            String username = input.next();
            System.out.print("Please enter new password(no spaces between): ");
            String pass_word = input.next();
            System.out.println("");
            int count = 0;
            for(int x=0;x<N;x++){
                if(username.equals(user[x])){
                    count++;
                    break;
                }
            }
            if(count == 1){
                System.out.println("Username existed");
            }else{
                user[N] = username;
                password[N] = pass_word;
                N = N + 1;
                System.out.println("new user successfully created");
            }
        }   
        else if(exist == 3){
            break;
        }
        else{
            System.out.println("Not a valid option");
        }
        if(success){
            System.out.println("Login successful");
            theprogram(user,password);
            success = false;
        }
        }
        System.out.println("Program ended, thank you for using this program.");
        try{
        File usernames = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\usernames.csv");
        File passwords = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\passwords.csv");
        PrintWriter user_names = new PrintWriter(usernames);
        PrintWriter pass_words = new PrintWriter(passwords);
        int k;
        for(k = 0;k<N-1;k++){
            user_names.print(user[k]+"\n");
            pass_words.print(password[k]+"\n");
        }
        user_names.print(user[k]);
        pass_words.print(password[k]);
        user_names.close();
        pass_words.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }  
    public static void theprogram(String[]user,String[]password){
        int [] count = {0}; //declare and initialize a count that will be used later
        counteritem(count); //to change the value of count[0] and build an array for lookupitems
        int[]countitem = {0}; //use to be the index a for newitem[a][],same goes to countpremise and pricecount
        System.out.println("number of items is: " + count[0]);
        String[][]items = new String[count[0]][5]; //declared and stored in the heed/stack
        count[0] = 0;//reinitialize to be used again
        Readitemlookup(items);//when items[][] is reffered in this class, any change made by this class will also be done on items[][]
        counterpremise(count); //to change the value of count[0] and build an array for lookup items;
        System.out.println("number of premises is: " +count[0]);
        int[]countpremise = {0};
        String[][]premise = new String[count[0]][6]; //declare and stored in heed/stack
        count[0]=0;//reinitialize
        Readpremiselookup(premise); //when items[][] is reffered in this class, any change made by this class will also be done on items[][]
        countprice(count); //to change the value of count[0] and build an array for pricecatcher;
        System.out.println("number of prices is: " + count[0]);
        int[]pricecount = {0};
        String[][]pricecatcher = new String[count[0]][4]; //same explanation as other 2
        pricecatch(pricecatcher);
        String[][]newitem = new String[1000][5];
        String[][]newpremise = new String[1000][6];
        String[][]newprice = new String[1000][4];
        String[][]cart = new String[1000][5];
        boolean tf = true;
        while(tf){
            System.out.println("PriceTracker - Track Prices with Ease\n");
            System.out.println("Welcome to Product Search and Selection\n");
            System.out.println("1. Import Data");
            System.out.println("2. Browse by categories");
            System.out.println("3. Search for a product");
            System.out.println("4. View Shopping Cart");
            System.out.println("5. Account Settings");
            System.out.println("6. Exit\n");
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your choice (1/2/3/4/5/6) : ");
            int choice = input.nextInt();
            if(choice == 1){
            importdata(newitem,newpremise,newprice,items,premise,pricecatcher,countitem,countpremise,pricecount);
            }else if(choice == 2){
            browse(items,premise,pricecatcher,cart);
            }else if(choice == 3){
            search(items,premise,pricecatcher,cart);
            }else if(choice == 4){
            shopcart(items,premise,pricecatcher,cart);
            }else if(choice == 5){
            account(user,password);
            }else if(choice == 6){
            tf = false;
            }else{
                System.out.println("Invalid choice, please enter number 1-6");
            }
            try{
        File item_s = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\lookup_item.csv");
        File premise_s = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\lookup_premise.csv");
        File price_caaatch = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\pricecatcher_2023-08.csv");
        PrintWriter ite_ms = new PrintWriter(item_s);
        PrintWriter premis_es = new PrintWriter(premise_s);
        PrintWriter price_caatch = new PrintWriter(price_caaatch);
        ite_ms.printf("%s,%s,%s,%s,%s\n",items[0][0],items[0][1],items[0][2],items[0][3],items[0][4]);
        for(int x = 1;x<items.length;x++){
            int y;
            for(y = 0;y<4;y++){
            ite_ms.print(items[x][y]+",");
            }
            ite_ms.print(items[x][y]);
            ite_ms.println("");
        }
        for(int x = 0;x<newitem.length;x++){
            if(newitem[x][0]!=null){
            int y;
            for(y = 0;y<4;y++){
            int countcoma = 0;
                for(int z = 0;z<newitem[x][y].length();z++){
                    if(newitem[x][y].charAt(z)==','){
                        countcoma++;
                        break;
                    }
                }
                if(countcoma==0){
                ite_ms.print(newitem[x][y]+",");
                }else{
                    ite_ms.print("\"" + newitem[x][y] +  "\",");
                }
            }
            int countcoma = 0;
                for(int z = 0;z<newitem[x][y].length();z++){
                    if(newitem[x][y].charAt(z)==','){
                        countcoma++;
                        break;
                    }
                }
                if(countcoma==0){
                ite_ms.print(newitem[x][y]);
                }else{
                    ite_ms.print("\"" + newitem[x][y] +  "\"");
                }
            ite_ms.println("");
            }
        }
        
        premis_es.printf("%s,%s,%s,%s,%s,%s\n",premise[0][0],premise[0][1],premise[0][2],premise[0][3],premise[0][4],premise[0][5]);
        for(int x = 1;x<premise.length;x++){
            int y;
            for(y=0;y<5;y++){
                premis_es.print(premise[x][y]+",");
            }
            premis_es.print(premise[x][y]);
            premis_es.println("");
        }
        for(int x = 0;x<newpremise.length;x++){
            if(newpremise[x][0]!=null){
            int y;
            for(y=0;y<5;y++){
                int countcoma = 0;
                for(int z = 0;z<newpremise[x][y].length();z++){
                    if(newpremise[x][y].charAt(z)==','){
                        countcoma++;
                        break;
                    }
                }
                if(countcoma==0){
                premis_es.print(newpremise[x][y]+",");
                }else{
                    premis_es.print("\"" + newpremise[x][y] +  "\",");
                }
            }
            int countcoma = 0;
                for(int z = 0;z<newpremise[x][y].length();z++){
                    if(newpremise[x][y].charAt(z)==','){
                        countcoma++;
                        break;
                    }
                }
                if(countcoma==0){
                premis_es.print(newpremise[x][y]);
                }else{
                    premis_es.print("\"" + newpremise[x][y] +  "\"");
                }
            premis_es.println("");
            }
        }
        
        price_caatch.printf("%s,%s,%s,%s\n",pricecatcher[0][0],pricecatcher[0][1],pricecatcher[0][2],pricecatcher[0][3]);
        for(int x = 1;x<pricecatcher.length;x++){
            int y;
            for(y = 0;y<3;y++){
            price_caatch.print(pricecatcher[x][y]+",");
            }
            price_caatch.print(pricecatcher[x][y]);
            price_caatch.println("");
        }
        for(int x = 0;x<newprice.length;x++){
            if(newprice[x][0]!=null){
            int y;
            for(y = 0;y<3;y++){
            price_caatch.print(newprice[x][y]+",");
            }
            price_caatch.print(newprice[x][y]);
            price_caatch.println("");
            }
        }
        
        ite_ms.close();
        premis_es.close();
        price_caatch.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        }
        
    }
    
    public static void Readitemlookup(String[][]items){ //to read and update the elements in String[][]items, to use this an array have to be declared first as above
        String line = ""; //declare object line
        try{
            int [] count = {0};
            counteritem(count);
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\lookup_item.csv"));
            int i = 0; //decalre int i to be the first index number in the array items[(this)][]
            while((line = br.readLine()) != null){ //line is given the value the Line readed from the file
                if(i<1){
                    items[i]=line.split(",");
                }
                if(i>=1&&i<count[0]){
                String[]item = line.split(","); //split the line readed from the file [i][0]-item_code [i][1]-item [i][2]-unit [i][3]-item_group [i][4]-item_category
                int length = item.length;
                items[i][0]= item[0];
                if(item[1].charAt(0) == '"' && item[1].charAt(item[1].length()-1)!='"'){
                    items[i][1] = item[1] + ",";
                    int x =2;
                    while((item[x].charAt(item[x].length()-1))!='"'){
                        items[i][1] = items[i][1]+item[x]+",";
                        x++;
                    }
                    items[i][1] = items[i][1]+item[x];
                    x++;
                    for(int j = 2;j<items[i].length;j++){
                        items[i][j] = item[x];
                        x++;
                    }
                }
                else{
                    items[i] = line.split(",");
                }
                }
                i++; //update i so the next line will be split and become the elements of the next items[i][]
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void counteritem(int [] count){ //this is to change the value of coutn[0] as it is reffered in this class, so any changes made in this class will relfect on count[0], all other count classes works as the same function
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\lookup_item.csv"));
            while((line = br.readLine()) != null){ //if the line readed has a value then count will +1 to know how many lines have value
                count[0]++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void Readpremiselookup(String[][]premise){ //to read and update the values in String[][]premise, how to use?same as items
        String line = ""; //declare and initialize object line
        try{
            int [] count = {0}; //for this class it is a little bit special so we will need this
            counterpremise(count); //update the count value for later use
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\lookup_premise.csv"));
            
            int i = 0; //initialize i to be used in premise[i][]
            while((line = br.readLine()) != null){ //line will become the line readed from the file
                if(i<1){
                    premise[i] = line.split(","); //only works for line 1 and 2 to split all elements, [0]-premise_code [1]-premise [2]-address [3]-premise_type [4]-state [5]-district
                }
                if(i>=1&&i<count[0]){//***
                String[]prem = line.split(",");//String[]prem is declared to help split all elements, now all element are split by , and all , dissapeared, however in some premise,address and district, they have coma also and will be splitted while they should be together as one element
                int length = prem.length; //hence we declare a length var to determine how much elements are splitted and will be used later
                premise[i][0] = prem[0]; //index 0 is always a number string and dont have "" so premise[0]=prem[0]
                if(prem[1].charAt(0)=='"'){ //some premise name have  , in it,and all of them have " in the start and the end, so add up the one start with " until the one end with " will make the premise name which should be in premise[1] when this condition is met
                    
                    premise[i][1] = prem[1] +  ",";
                    int x = 2;
                    while((prem[x].charAt(prem[x].length()-1))!='"'){
                        premise[i][1] = premise[i][1]+prem[x]+",";
                        x++;
                    }
                    premise[i][1]=premise[i][1]+prem[x];
                    x++;
                    premise[i][2] = ""; //initialize premise[i][2] which should be the address
                    while((prem[x].charAt(prem[x].length()-1))!='"'){ //so address always ends with a " behind the last element that should be in the address element
                        premise[i][2] = premise[i][2]+prem[x]+","; //so we add up all the elements that before that last element that have " in the end of it,making up the address with comas between every word
                        x++; //update x
                    }
                    premise[i][2]=premise[i][2]+prem[x]; //when the "last address element" that have " is reached, the loop will stop and that element will not be added, so we add it here
                    x++;
                    int j = 3; //for [i][3] and [i][4], there is no problem bcause they are always one element without ,
                    while(j<5){
                        premise[i][j] = prem[x]; //so we just have to give them the values which held in the 2 current prem[x]
                        j++;
                        x++;
                    }
                    if(prem[x].charAt(0) == '"'){ //for the last element,district some of them have , between them, so will they be splitted
                        while(x<length){ //while x is smaller than value of length, the loop will go on, until the last element in prem[] is reached
                            premise[i][5] += prem[x];//hence we combine them into one element
                            x++;
                        }
                    }else{ // for those district that have no , between just initialize them as normal, assign the value of the last x into it.
                        premise[i][5] = prem[x];
                    }
                }else{ //for those premise name that dont have , all explanation for the codes are same as all in above
                    premise[i][1]=prem[1]; //because no , the value splitted into prem[1] will be premise[i][1]
                    int x = 2;
                    premise[i][2] = "";
                    while((prem[x].charAt(prem[x].length()-1))!='"'){
                        premise[i][2] = premise[i][2]+prem[x]+",";
                        x++;
                    }
                    premise[i][2]=premise[i][2]+prem[x];
                    x++;
                    int j = 3;
                    while(j<5){
                        premise[i][j] = prem[x];
                        j++;
                        x++;
                    }
                    if(prem[x].charAt(0) == '"'){
                        while(x<length){
                            premise[i][5] += prem[x];
                            x++;
                        }
                    }else{
                        premise[i][5]=prem[x];
                    }
                }
                }
                i++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void counterpremise(int [] count){ 
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\lookup_premise.csv"));
            while((line = br.readLine()) != null){
                count[0]++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /////////////////////////////////////////////////////////////////
    
    public static void pricecatch(String[][]pricecatcher){ //a class built for reading the values in pricecatcher file into pricecatcher array
        String line = ""; //declare object line
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\pricecatcher_2023-08.csv"));
            int i = 0;
            while((line = br.readLine()) != null){ //line will hold the value read from the csv file
                pricecatcher[i] = line.split(","); //line will be splitted into elements and stored in pricecatcher[][],[0]-date[1]-premise_code[2]-item_code[3]-price
                i++; //update i so next line will be stored in next pricecatcher[i]
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void countprice(int[]count){
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\tester2111\\src\\tester2111\\pricecatcher_2023-08.csv"));
            while((line = br.readLine()) != null){
                count[0]++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void importdata(String[][]newitem,String[][]newpremise,String[][]newprice,String[][]items,String[][]premise,String[][]pricecatcher,int[]countitem,int[]countpremise, int[]pricecount){
        Scanner input = new Scanner(System.in);
        int ans=0;
        String line = "";
        while(ans!=2){
        System.out.println("Do you want to import new data.YES-1,NO-2");
        ans=input.nextInt();
        if(ans==1){
            System.out.println("1.item"+"\n2.Premise"+"\n3.Price");
            int choose=input.nextInt();
            
            switch(choose)
                    { case 1:
                        while (true){
                            int count = 0;
                            System.out.println("Enter the item code");
                            line=input.next();
                            input.nextLine();
                            checkitemcode:
                            for(int x = 1;x<items.length;x++){
                                if(line.equals(items[x][0])){
                                    System.out.println("item code exists");
                                    count++;
                                    break;
                                }
                            }
                            for(int y = 0;y<newitem.length;y++){
                                if(line.equals(newitem[y][0])){
                                    System.out.println("item code exists");
                                    count++;
                                    break;
                                }
                            }
                            if (count==0){
                                newitem[countitem[0]][0]=line;
                                break;
                            }
                        }
                        while (true){
                            int count = 0;
                            System.out.println("Enter the item");
                            line=input.nextLine();
                            checkitem:
                            for(int x = 1;x<items.length;x++){
                                if(line.equals(items[x][1])){
                                    System.out.println("item exists");
                                    count++;
                                    break;
                                }        
                            }
                            for(int y = 0;y<newitem.length;y++){
                                if(line.equals(newitem[y][1])){
                                    System.out.println("item exists");
                                    count++;
                                    break;
                                }
                            }
                            if (count==0){
                                newitem[countitem[0]][1]=line;
                                break;
                            }
                        }
                        System.out.println("Enter the unit of the item");
                        newitem[countitem[0]][2]=input.nextLine();
                        System.out.println("Enter the item group");
                        newitem[countitem[0]][3]=input.nextLine();
                        System.out.println("Enter the item category");
                        newitem[countitem[0]][4]=input.nextLine();
                        countitem[0]++;
                        break;
            
            
                    case 2:
                        while (true){
                            int count = 0;
                            System.out.println("Enter the premise code");
                            line=input.next();
                            input.nextLine();
                            checkpremisecode:
                            for(int x = 1;x<premise.length;x++){
                                if(line.equals(premise[x][0])){
                                    System.out.println("premise code exists");
                                    count++;
                                    break;
                                }
                            }
                            for(int y = 0;y<newpremise.length;y++){
                                if(line.equals(newpremise[y][0])){
                                    System.out.println("premise code exists");
                                    count++;
                                    break;
                                }
                            }
                            if (count==0){
                                newpremise[countpremise[0]][0]=line;
                                break;
                            }
                        }
                        while (true){
                            int count = 0;
                            System.out.println("Enter the premise");
                            line=input.nextLine();
                            checkpremise:
                            for(int x = 1;x<premise.length;x++){
                                if(line.equals(premise[x][1])){
                                    System.out.println("premise exists");
                                    count++;
                                    break;
                                }
                            }
                            for(int y = 0;y<newpremise.length;y++){
                                if(line.equals(newpremise[y][1])){
                                    System.out.println("premise exists");
                                    count++;
                                    break;
                                }
                            }
                            if (count==0){
                                newpremise[countpremise[0]][1]=line;
                                break;
                            }
                        }
                        System.out.println("Enter the premise address");
                        newpremise[countpremise[0]][2]=input.nextLine();
                        System.out.println("Enter the premise type");
                        newpremise[countpremise[0]][3]=input.nextLine();
                        System.out.println("Enter the state");
                        newpremise[countpremise[0]][4]=input.nextLine();
                        System.out.println("Enter the district");
                        newpremise[countpremise[0]][5]=input.nextLine();
                        countpremise[0]++;
                        break;
            
                    case 3:
                        while(true){
                            int count = 0;
                        System.out.println("Enter the date(YYYY-MM-DD)");
                        String line1=input.next();
                        System.out.println("Enter the premise code");
                        String line2=input.next();
                        System.out.println("Enter the item code");
                        String line3=input.next();
                        for(int x = 0;x<pricecatcher.length;x++){
                            if(line1.equals(pricecatcher[x][0])&&line2.equals(pricecatcher[x][1])&&line3.equals(pricecatcher[x][2])){
                                System.out.println("The combination of the date,premise code and item code entered already exists");
                                count++;
                                break;
                            }
                        }
                        for(int y = 0;y<newprice.length;y++){
                            if(line1.equals(newprice[y][0])&&line2.equals(newprice[y][1])&&line3.equals(newprice[y][2])){
                                System.out.println("The combination of the date,premise code and item code entered already exists");
                                count++;
                                break;
                            }
                        }
                        if(count==0){
                            newprice[pricecount[0]][0]=line1;
                            newprice[pricecount[0]][1]=line2;
                            newprice[pricecount[0]][2]=line3;
                            break;
                        }
                        }
                        System.out.println("Enter the price");
                        newprice[pricecount[0]][3]=input.next();
                        pricecount[0]++;
                        break;
            }       
        }
     }
    }
    
    public static void browse(String[][]items,String[][]premise,String[][]pricecatcher,String[][]cart){
        Scanner input = new Scanner(System.in);
        int count = 0;
        for(int i =1;i<items.length;i++){ //first line is title so start with 1
            String cat = items[i][3];
            int check = 0;
            for(int j=1;j<i;j++){ //start with 1, same reason
                if(cat.equals(items[j][3])){
                    check = 1;
                    break;
                }
            }
            if(check!=1){
                count++;
            }
        }
        String[][][]categories = new String[count][2][];
        int c = 0;
        for(int i = 0;i<count;i++){
            categories[i][0] = new String[1];
        }
        for(int i = 1;i<items.length;i++){ //first line is title so start with 1
            if(c<count){ 
            String cat = items[i][3];
            int check = 0;
            for(int j=1;j<i;j++){ //start with 1, same reason
                if(cat.equals(items[j][3])){
                    check = 1;
                    break;
                }
            }
            if(check!=1){
               categories[c][0][0] = cat;
               c++;
            }
        }
        }
        
        for(int i = 0;i<categories.length;i++){
            int subbs = 0;
            for(int j = 1;j<items.length;j++){
                if(items[j][3].equals(categories[i][0][0])){
                    subbs++;
                }
            }
            String[][]sbbs = new String[subbs][5];
            for(int j = 0;j<subbs;){
                for(int k = 1;k<items.length;k++){
                    if(items[k][3].equals(categories[i][0][0])){
                        sbbs[j] = items[k];
                        j++;
                    }
                }
            }
            
            int countsub = 0;
            for(int j = 0;j<sbbs.length;j++){
                String subcat = sbbs[j][4];
                int check = 0;
                for(int y=0;y<j;y++){ //start with 1, same reason
                    if(subcat.equals(sbbs[y][4])){
                        check = 1;
                        break;
                    }
                }
                if(check!=1){
                    countsub++;
                }       
            }
            
            categories[i][1] = new String[countsub];
            int sc = 0;
            for(int j = 0;j<sbbs.length;j++){
                if(sc<countsub){
                String subcat = sbbs[j][4];
                int check = 0;
                for(int y=0;y<j;y++){ //start with 1, same reason
                    if(subcat.equals(sbbs[y][4])){
                        check = 1;
                        break;
                    }
                }
                if(check!=1){
                    categories[i][1][sc]=subcat;
                    sc++;
                }
            }
            }
        }
        
        System.out.printf("There are %d categories\n",count);
        while(true){
        System.out.println("Select a Category :");
        System.out.println();
        int a;
        for(a = 0;a<categories.length;a++){
            System.out.printf("%d. %s\n",a+1,categories[a][0][0]);
        }
        System.out.printf("%d. Back to Main Menu\n",a+1);
        
        System.out.print("\nEnter your choice : ");
        int choice = input.nextInt();
        String category = "";
        String subcategory = "";
        
        if(choice<=0){
            System.out.println("Invalid choice");
        }else if(choice<=a){
            while(true){
            category = categories[choice-1][0][0];
            System.out.println("Select sub category: ");
            int b;
            for(b = 0;b<categories[choice-1][1].length;b++){
                System.out.printf("%d. %s\n",b+1,categories[choice-1][1][b]);
            }
            System.out.printf("%d. Back to categories\n",b+1);
            System.out.print("\nEnter your choice: ");
            int sub = input.nextInt();
            if(sub<=0){
                System.out.println("Invalid choice");
            }else if(sub<=b){
                while(true){
                subcategory = categories[choice-1][1][sub-1];
                int its = 0;
                for(int i = 1;i<items.length;i++){
                    if(category.equals(items[i][3])&&subcategory.equals(items[i][4])){
                        its++;
                    }
                }
                System.out.println(its + " items found");
                String[][]it = new String[its][5];
                int couti = 0;
                for(int i = 1;i<items.length;i++){
                    if(category.equals(items[i][3])&&subcategory.equals(items[i][4])){
                        it[couti] = items[i];
                        couti++;
                    }
                }
                for(int i = 0;i<it.length;i++){
                    System.out.printf("%d. %s\n",i+1,it[i][1]);
                }
                System.out.printf("%d. Back to sub categories\n",it.length+1);
                System.out.println("Please select one: ");
                int select = input.nextInt();
                if(select<=0){
                    System.out.println("Invalid choice");
                }else if(select<=it.length){
                    String[]selected = it[select-1];
                    selection(items,premise,pricecatcher,cart,selected);
                }else if(select==it.length+1){
                    break;
                }else{
                    System.out.println("Invalid choice");
                }
                //you stopped here*****
                }
            }else if(sub == b+1){
                break;
            }else{
                System.out.println("Invalid choice");
            }
            }
        }else if(choice == a+1){
            break;
        }else{
            System.out.println("Invalid choice");
        }
        
        }
    }
    
    public static void search(String[][]items,String[][]premise,String[][]pricecatcher,String[][]cart){
        System.out.println("search");
    }
    
    public static void shopcart(String[][]items,String[][]premise,String[][]pricecatcher,String[][]cart){
        System.out.println("Shopping cart\n");
        
        System.out.println("1. View cheapest seller for all selected items");
        System.out.println("2. Find shops to buy items in cart");
    }
    
    public static void account(String[]user,String[]password){
        Scanner input=new Scanner(System.in);
        int N = 1000;
        boolean success=false;
        boolean success1=false;
        int i;
        loginforsettings:
        while(true){
        System.out.print("Enter your existing username: ");
        String user1=input.next();
        for(i=0;i<N;i++){
            if(user1.equals(user[i])){
                System.out.print("Enter your password: ");
                String password1=input.next();
                if(password1.equals(password[i])){
                    success=true;
                    success1=true;
                    break loginforsettings;
                }else{
                    System.out.println("Password incorrect");
                    break;
                }    
            }
        }
        if(i==N){
            System.out.println("Invalid username");
        }
        }
        if(success){
            System.out.print("Do you want to change your  username.1-YES.2-NO: ");
            int ans=input.nextInt();
            while(ans==1){
                System.out.print("Enter new username: ");
                String user2=input.next();
                int count = 0;
                for(int x=0;x<N;x++){
                    if(user2.equals(user[x])){
                        count++;
                        break;
                    }
                }
                if(count == 1){
                    System.out.println("Username existed");
                }else{
                    user[i] = user2;
                    System.out.println("Changes username successfully");
                    success=false;
                    break;
                   
            }
            }
        }
            if(success1){
            System.out.println("Do you want to change your  password.1-YES.2-NO");
            int ans=input.nextInt();
            while(ans==1){
                System.out.print("Enter new password: ");
                String password2=input.next();
                int count = 0;
                for(int x=0;x<N;x++){
                    if(password2.equals(password[x])){
                        count++;
                        break;
                    }
                }
                if(count == 1){
                    System.out.println("Same as the previous password");
                }else{
                    password[i] = password2;
                    System.out.println("Changes password successfully");
                    success1=false;
                    break;
                   
            }
            }
        
        
        
        
        
        
    }
    }
    
    public static void selection(String[][]items,String[][]premise,String[][]pricecatcher,String[][]cart,String[]selection){
        System.out.println("Selected item is: " + selection[1]);
        System.out.println("Details: ");
        System.out.println("aaaa");
    }
    
    
}
