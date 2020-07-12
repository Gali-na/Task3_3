import exception.IllegalDateParametersException;

import java.time.LocalDate;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo)
            throws Exception {
        String[] dateFromAr = dateFrom.split("[(.)]");
        String[] dateToAr = dateTo.split("[(.)]");
        StringBuilder dateFromTemp;
        dateFromTemp = new StringBuilder(dateFromAr[2] + "-" + dateFromAr[1] + "-" + dateFromAr[0]);
        StringBuilder dateFromTo;
        dateFromTo = new StringBuilder(dateToAr[2] + "-" + dateToAr[1] + "-" + dateToAr[0]);
        StringBuilder order;
        order = new StringBuilder("Отчёт за период" + " " + dateFrom + " - " + dateTo);
        LocalDate dateStart = LocalDate.parse(dateFromTemp.toString());
        LocalDate localStop = LocalDate.parse(dateFromTo.toString());
        for (int i = 0; i < names.length; i++) {
            int moneySum = 0;
            String nameInOrder = new String();
            for (int j = 0; j < data.length; j++) {
                String[] dataEach = new String[4];
                dataEach = data[j].split(" ");
                String dataTest = dataEach[0];
                String separator = "[(.)]";
                String[] dateAr;
                dateAr = dataTest.split(separator);
                StringBuilder localTemp;
                localTemp = new StringBuilder(dateAr[2] + "-" + dateAr[1] + "-" + dateAr[0]);
                LocalDate localDate;
                localDate = LocalDate.parse(localTemp.toString());
                StringBuilder dataName = new StringBuilder(dataEach[1]);
                int hours = Integer.parseInt(dataEach[2]);
                int money = Integer.parseInt(dataEach[3]);
                if ((names[i].equals(dataName.toString()))
                        && localStop.compareTo(dateStart) >= 0
                        && localDate.compareTo(dateStart) >= 0
                        && localDate.compareTo(localStop) <= 0) {
                    moneySum = moneySum + (money * hours);
                    nameInOrder = names[i];
                }
                if (localStop.compareTo(dateStart) < 0) {
                    moneySum = 0;
                }
                nameInOrder = names[i];
            }
            order.append("\n" + nameInOrder + " " + "- " + moneySum);
            if (localStop.compareTo(dateStart) < 0) {

                throw new IllegalDateParametersException("Wrong parameters");
            }
        }
        return order.toString();
    }
}