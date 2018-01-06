package baseball.player.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("psvo")
public class PlayerStatVo {

	String game_num, year, month, day, teamId, playerId, playerName, positionToday, //선수기본정보
			g, gs, inn, tc, po, a, e, dp, fpct, rf,//수비지표
			ab, r, h, twoBase, thirdBase, hr, rbi, bb, so, sb, cs, avg, obp, slg, ops,//타자지표
			w, l, hold, era, sv, svo, ip, pitcherH, pitcherR, er,
			pitcherHr, pitcherBb, pitcherSo, pitcherAvg, whip;//투수지표
	Date regDate;
	
	
	public String getGame_num() {
		return game_num;
	}
	public void setGame_num(String game_num) {
		this.game_num = game_num;
	}
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
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPositionToday() {
		return positionToday;
	}
	public void setPositionToday(String positionToday) {
		this.positionToday = positionToday;
	}
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}
	public String getGs() {
		return gs;
	}
	public void setGs(String gs) {
		this.gs = gs;
	}
	public String getInn() {
		return inn;
	}
	public void setInn(String inn) {
		this.inn = inn;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public String getDp() {
		return dp;
	}
	public void setDp(String dp) {
		this.dp = dp;
	}
	public String getFpct() {
		return fpct;
	}
	public void setFpct(String fpct) {
		this.fpct = fpct;
	}
	public String getRf() {
		return rf;
	}
	public void setRf(String rf) {
		this.rf = rf;
	}
	public String getAb() {
		return ab;
	}
	public void setAb(String ab) {
		this.ab = ab;
	}
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	public String getH() {
		return h;
	}
	public void setH(String h) {
		this.h = h;
	}
	public String getTwoBase() {
		return twoBase;
	}
	public void setTwoBase(String twoBase) {
		this.twoBase = twoBase;
	}
	public String getThirdBase() {
		return thirdBase;
	}
	public void setThirdBase(String thirdBase) {
		this.thirdBase = thirdBase;
	}
	public String getHr() {
		return hr;
	}
	public void setHr(String hr) {
		this.hr = hr;
	}
	public String getRbi() {
		return rbi;
	}
	public void setRbi(String rbi) {
		this.rbi = rbi;
	}
	public String getBb() {
		return bb;
	}
	public void setBb(String bb) {
		this.bb = bb;
	}
	public String getSo() {
		return so;
	}
	public void setSo(String so) {
		this.so = so;
	}
	public String getSb() {
		return sb;
	}
	public void setSb(String sb) {
		this.sb = sb;
	}
	public String getCs() {
		return cs;
	}
	public void setCs(String cs) {
		this.cs = cs;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public String getObp() {
		return obp;
	}
	public void setObp(String obp) {
		this.obp = obp;
	}
	public String getSlg() {
		return slg;
	}
	public void setSlg(String slg) {
		this.slg = slg;
	}
	public String getOps() {
		return ops;
	}
	public void setOps(String ops) {
		this.ops = ops;
	}
	public String getW() {
		return w;
	}
	public void setW(String w) {
		this.w = w;
	}
	public String getL() {
		return l;
	}
	public void setL(String l) {
		this.l = l;
	}
	public String getHold() {
		return hold;
	}
	public void setHold(String hold) {
		this.hold = hold;
	}
	public String getEra() {
		return era;
	}
	public void setEra(String era) {
		this.era = era;
	}
	public String getSv() {
		return sv;
	}
	public void setSv(String sv) {
		this.sv = sv;
	}
	public String getSvo() {
		return svo;
	}
	public void setSvo(String svo) {
		this.svo = svo;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPitcherH() {
		return pitcherH;
	}
	public void setPitcherH(String pitcherH) {
		this.pitcherH = pitcherH;
	}
	public String getPitcherR() {
		return pitcherR;
	}
	public void setPitcherR(String pitcherR) {
		this.pitcherR = pitcherR;
	}
	public String getEr() {
		return er;
	}
	public void setEr(String er) {
		this.er = er;
	}
	public String getPitcherHr() {
		return pitcherHr;
	}
	public void setPitcherHr(String pitcherHr) {
		this.pitcherHr = pitcherHr;
	}
	public String getPitcherBb() {
		return pitcherBb;
	}
	public void setPitcherBb(String pitcherBb) {
		this.pitcherBb = pitcherBb;
	}
	public String getPitcherSo() {
		return pitcherSo;
	}
	public void setPitcherSo(String pitcherSo) {
		this.pitcherSo = pitcherSo;
	}
	public String getPitcherAvg() {
		return pitcherAvg;
	}
	public void setPitcherAvg(String pitcherAvg) {
		this.pitcherAvg = pitcherAvg;
	}
	public String getWhip() {
		return whip;
	}
	public void setWhip(String whip) {
		this.whip = whip;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "PlayerStatVo [year=" + year + ", month=" + month + ", day=" + day + ", teamId=" + teamId + ", playerId="
				+ playerId + ", playerName=" + playerName + ", positionToday=" + positionToday + ", g=" + g + ", gs="
				+ gs + ", inn=" + inn + ", tc=" + tc + ", po=" + po + ", a=" + a + ", e=" + e + ", dp=" + dp + ", fpct="
				+ fpct + ", rf=" + rf + ", ab=" + ab + ", r=" + r + ", h=" + h + ", twoBase=" + twoBase + ", thirdBase="
				+ thirdBase + ", hr=" + hr + ", rbi=" + rbi + ", bb=" + bb + ", so=" + so + ", sb=" + sb + ", cs=" + cs
				+ ", avg=" + avg + ", obp=" + obp + ", slg=" + slg + ", ops=" + ops + ", w=" + w + ", l=" + l
				+ ", hold=" + hold + ", era=" + era + ", sv=" + sv + ", svo=" + svo + ", ip=" + ip + ", pitcherH="
				+ pitcherH + ", pitcherR=" + pitcherR + ", er=" + er + ", pitcherHr=" + pitcherHr + ", pitcherBb="
				+ pitcherBb + ", pitcherSo=" + pitcherSo + ", pitcherAvg=" + pitcherAvg + ", whip=" + whip
				+ ", regDate=" + regDate + "]";
	}
	
	

	
}
