import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class ReadAccounts {

    String URL = "";
    BufferedReader reader = null;
    String line = "";

    private LinkedList<String> firstNames = new LinkedList<>();
    private LinkedList<String> lastNames = new LinkedList<>();
    private LinkedList<Integer> accountList = new LinkedList<>();
    private LinkedList<Integer> balanceList = new LinkedList<>();


    public ReadAccounts(String URL){
        this.URL = URL;

    }

    public void readFile(LinkedList<String> firstNames, LinkedList<String> lastNames, LinkedList<Integer> accountList, LinkedList<Integer> balanceList) {
        try {
            reader = new BufferedReader(new FileReader(URL));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                // Assuming the first name is at index 0 and the last name is at index 1 //
                firstNames.add(row[0].trim());
                lastNames.add(row[1].trim());
                accountList.add(Integer.valueOf(row[2].trim()));
                balanceList.add(Integer.valueOf(row[3].trim()));

                // Looping through the file and printing it //
                for (String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        } catch (Exception e) {       // Handling exceptions //
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }


    public LinkedList<String> getFirstNames(){
        return firstNames;
    }
    public LinkedList<String> getLastNames(){
        return lastNames;
    }
    public LinkedList<Integer> getAccounts(){
        return accountList;
    }
    public LinkedList<Integer> getBalances(){
        return balanceList;
    }

}
