package org.example.service;


import org.springframework.stereotype.Service;

@Service
public class TimeConversionService {


    public String convertTimeToWords ( String string){

        String time[] = string.split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);

        if(hours==0 && minutes ==0)
            return "Its midnight!";

        else if(hours==12 && minutes ==12)
            return "Its midday!";

        else {
            String hourInWords = convertToWords(hours);
            String minuteInWords = convertToWords(minutes);
            return "It's " + hourInWords + " " + minuteInWords;
        }
    }


    public String convertToWords(int num){
        String[] units = {
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };

        String[] tens = {
                "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
        };

        if (num == 0) {
            return "zero";
        }

        if (num < 20) {
            return units[num];
        }

        if (num < 100) {
            return tens[num / 10] + (num % 10 > 0 ? " " + units[num % 10] : "");
        }

        return "Invalid time, minutes max are 60";
    }

}
