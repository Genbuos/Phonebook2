package phonebook;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = new LinkedHashMap<>(map != null ? map : new LinkedHashMap<>());
    }

    public PhoneBook() {
        this(null);
    }

    public void add(String name, String phoneNumber) {
        String newNum = formatPhoneNumber(phoneNumber);
        phonebook.put(name, Collections.singletonList(newNum));
    }

    public void addAll(String name, String... phoneNumbers) {
        ArrayList<String> numbers = new ArrayList<>(Arrays.stream(phoneNumbers).toList());
        for (int i =0; i < numbers.size(); i++) {
           String newNum = formatPhoneNumber(numbers.get(i));
            numbers.set(i, newNum);

        }
        phonebook.put(name, numbers);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        List<String> numbers = phonebook.get(name);
        List<String> result = new ArrayList<>();
        for (String number: numbers) {
            String newNum = formatPhoneNumber(number);
            result.add(newNum);
        }
        return result;
    }

    public String reverseLookup(String phoneNumber)  {
        String newNum = formatPhoneNumber(phoneNumber);


        for (Map.Entry<String, List<String>> entry: phonebook.entrySet()) {
            List<String> numbers = entry.getValue();
            if (numbers.contains(newNum)){
                System.out.println("Match For: " + newNum);
                return entry.getKey();
            }
        }
        return "Number not found.";
    }

    public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<>(phonebook.keySet());

        return contactNames;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }


    private String formatPhoneNumber(String phoneNumber) {
        // Remove any non-numeric characters from the phone number
        /**
         * @method
         */
        String cleanedNumber = phoneNumber.replaceAll("[^0-9]", "");

        // Use a regular expression to format the cleaned number with dashes
        Pattern pattern = Pattern.compile("(\\d{3})(\\d{3})(\\d{4})");
        Matcher matcher = pattern.matcher(cleanedNumber);

        if (matcher.matches()) {


            return String.format("(%s)-%s-%s", matcher.group(1), matcher.group(2), matcher.group(3));
        } else {
            // If the phone number doesn't match the expected format, return it as-is
            return phoneNumber;
        }
    }


}