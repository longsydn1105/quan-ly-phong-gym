package model.bean;

import java.sql.Timestamp;

public class CheckTime {
	public boolean CheckEndTime(String startTime, String endTime, String date) {
	    boolean check = false;

	    try {
	        // Kiểm tra tham số đầu vào có hợp lệ hay không
	        if (startTime == null || endTime == null || date == null 
	                || startTime.isEmpty() || endTime.isEmpty() || date.isEmpty()) {
	            System.out.println("Tham số không được để trống.");
	            return false;
	        }

	        // Tạo Timestamp từ chuỗi
	        Timestamp startTimeST = Timestamp.valueOf(date + " " + startTime + ":00");
	        Timestamp endTimeST = Timestamp.valueOf(date + " " + endTime + ":00");

	        // Kiểm tra endTime có sau startTime không
	        check = endTimeST.after(startTimeST);

	    } catch (IllegalArgumentException e) {
	        // Xử lý lỗi định dạng thời gian
	        System.out.println("Định dạng thời gian không hợp lệ. Định dạng đúng là yyyy-MM-dd HH:mm.");
	        e.printStackTrace();
	    } catch (Exception e) {
	        // Bắt các lỗi khác
	        e.printStackTrace();
	    }

	    return check;
	}
}
