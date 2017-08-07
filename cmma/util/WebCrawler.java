/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.util;

import com.ihpc.cmma.model.Event;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sruthi
 */
public class WebCrawler {
    
    public List<Event> eventCrawler(int month,int year) throws Exception{
        String strTemp = "";
        String strTemp1 = "";
        List<Event> events = new ArrayList<>();
        try {
            URL my_url = new URL("http://www.sunteccity.com.sg/happenings.php?mt="+month+"&yr="+year);
            BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));
            
            while(null != (strTemp = br.readLine())){
              
                strTemp1=strTemp1+strTemp;
                             }
                Pattern pattern1 = Pattern.compile("title:'(.*?)'");
                Matcher matcher1 = pattern1.matcher(strTemp1);
                pattern1=Pattern.compile("summary:'(.*?)'");
                Matcher matcher2=pattern1.matcher(strTemp1);
                pattern1=Pattern.compile("icon:'(.*?)'");
                Matcher matcher4=pattern1.matcher(strTemp1);                
                pattern1=Pattern.compile("Validity:(.*?)<");
                Matcher matcher3=pattern1.matcher(strTemp1);
                
                while(matcher1.find()&&matcher2.find()&&matcher3.find()&&matcher4.find())
                {
                    Event event = new Event();
                    event.setEventName(matcher1.group(1));
                    event.setEventDescription(matcher2.group(1));
                    Date dates[] = dateFormatter(matcher3.group(1));
                    event.setEventStartDate(dates[0]);
                    event.setEventEndDate(dates[1]);
                    String imgUrl = matcher4.group(1);
                    String fileName = imgUrl.substring(imgUrl.lastIndexOf("/")+1);
                    if(fileName!=null && !fileName.equals("")){
                        FileUtils.saveFile(imgUrl,PropertyUtil.getPropery("event_images")+fileName);
                        event.setEventPhoto(fileName);
                    }else{
                        event.setEventPhoto(PropertyUtil.getPropery("image_notAvailable"));
                    }
                    
                    
                    event.setIsWebCrawled(CmmaConstants.NUMBER_ONE);
                    event.setEventVenue("");
                    events.add(event);
                    
                                  }
           } catch (ParseException | IOException ex) {
            Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return events;
    }
    
    private Date[] dateFormatter(String dateStr) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
        Date[] dates = new Date[2];
        String split[] = dateStr.split("-");
        dates[1] = format.parse(split[1]);

        try {
            format.parse(split[0]);
        } catch (ParseException pe) {
            split[0] = split[0] + formatNowYear.format(dates[1]);
        }

        dates[0] = format.parse(split[0]);
        return dates;
    }
}
