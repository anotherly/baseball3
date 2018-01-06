package baseball.schedule.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("schevo")
public class ScheduleVo {

	String year, month, day, yoil, 
	game_num, game_time, home_img, away_img, channel,
	 away, home, away_score, home_score, stadium;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getYoil() {
		return yoil;
	}

	public void setYoil(String yoil) {
		this.yoil = yoil;
	}

	public String getGame_num() {
		return game_num;
	}

	public void setGame_num(String game_num) {
		this.game_num = game_num;
	}

	public String getGame_time() {
		return game_time;
	}

	public void setGame_time(String game_time) {
		this.game_time = game_time;
	}

	public String getHome_img() {
		return home_img;
	}

	public void setHome_img(String home_img) {
		this.home_img = home_img;
	}

	public String getAway_img() {
		return away_img;
	}

	public void setAway_img(String away_img) {
		this.away_img = away_img;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getAway() {
		return away;
	}

	public void setAway(String away) {
		this.away = away;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getAway_score() {
		return away_score;
	}

	public void setAway_score(String away_score) {
		this.away_score = away_score;
	}

	public String getHome_score() {
		return home_score;
	}

	public void setHome_score(String home_score) {
		this.home_score = home_score;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	@Override
	public String toString() {
		return "ScheduleVo [year=" + year + ", month=" + month + ", day=" + day + ", yoil=" + yoil + ", game_num="
				+ game_num + ", game_time=" + game_time + ", home_img=" + home_img + ", away_img=" + away_img
				+ ", channel=" + channel + ", away=" + away + ", home=" + home + ", away_score=" + away_score
				+ ", home_score=" + home_score + ", stadium=" + stadium + "]";
	}


}
