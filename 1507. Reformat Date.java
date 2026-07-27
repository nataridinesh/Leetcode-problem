class Solution {
    public String reformatDate(String date) {
        String[] parts = date.split(" ");
        String dayStr = parts[0];
        String monthStr = parts[1];
        String yearStr = parts[2];

      
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

      
        String dayNum = dayStr.substring(0, dayStr.length() - 2);
        if (dayNum.length() == 1) {
            dayNum = "0" + dayNum;
        }

      
        return yearStr + "-" + months.get(monthStr) + "-" + dayNum;
    }
}
