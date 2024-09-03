package org.blitmatthew;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Nazi", 34, 7, 6.00, 200.00, "Male");

//        FileOutputStream fout = new FileOutputStream("src/main/resources/person.txt", true);
//
//        char[] nameArray = person.getName().toCharArray();
//
//        for (int i = 0; i < nameArray.length; i++) {
//            fout.write(nameArray[i]);
//        }
//        fout.write('\n');
//        char[] ageArray = person.getAge().toString().toCharArray();
//        for (int i = 0; i < ageArray.length; i++) {
//            fout.write(ageArray[i]);
//        }
//        fout.write('\n');
//        char[] noOfFingersArray = person.getNoOfFingers().toString().toCharArray();
//        for (int i = 0; i < noOfFingersArray.length; i++) {
//            fout.write(noOfFingersArray[i]);
//        }
//        fout.write('\n');
//        fout.write(person.getGender().getBytes());
//        fout.write('\n');
//
//        FileInputStream fin = new FileInputStream("person.txt");
//
//        int ch;
//        while((ch = fin.read()) != -1) {
//            System.out.print((char) ch);
//        }
//        System.out.println();
//        System.out.println((char)65);
//        System.out.println((char)97);

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();

        objectNode.put("name", person.getName());
        objectNode.put("age", person.getAge());
        objectNode.put("height", person.getHeight());
        objectMapper.writeValue(new File("person.json"), objectNode);
    }
}