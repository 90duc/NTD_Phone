package com.mk.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mk.dao.impl.BuyerDao;
import com.mk.dao.impl.WanterDao;
import com.mk.entity.BuyerRemark;
import com.mk.entity.Phone;
import com.mk.entity.RemarkPK;
import com.mk.entity.WanterRemark;
import com.mk.info.NameInfo;
import com.mk.info.MsgInfo.Login;
import com.mk.info.status.Status;
import com.mk.util.Utils;
@Transactional
@org.springframework.stereotype.Service
public class RemarkService {

	@Autowired
	private WanterDao wantDao;

	@Autowired
	private BuyerDao buyerDao;

	public List<Map<String, Object>> getWanterRemark(Integer id, Integer start,
			Integer limit) {
		List<Map<String, Object>> wList = null;

		if (Utils.isNull(id) || Utils.isNull(start) || Utils.isNull(limit))
			return wList;
		wList = wantDao.list(id, start, limit);

		return wList;
	}

	public List<Map<String, Object>> getBuyerRemark(Integer id, Integer start,
			Integer limit) {
		List<Map<String, Object>> wList = null;

		if (Utils.isNull(id) || Utils.isNull(start) || Utils.isNull(limit))
			return wList;

		wList = buyerDao.list(id, start, limit);
		return wList;
	}

	public Map<String, Object> saveWanterRemark(String text, Integer pid,
			Integer uid, Integer rank) {
		Map<String, Object> map = new HashMap<>();
		Status status = null;
		text = Utils.toTrimOrNull(text);
		if (Utils.isNull(pid)) {
			status = Status.error("pid为空");
		} else if (Utils.isNull(uid)) {
			status = Status.error("uid为空");
		} else if (Utils.isNull(rank)||rank==0) {
			status = Status.error("评分为空");
		}else if (Utils.isNull(text)) {
			status = Status.error("评论为空");
		} else {
			WanterRemark wRemark = new WanterRemark();
			wRemark.setPK(new RemarkPK(pid, uid));
			wRemark.setTime(new Date());
			wRemark.setText(text);
			wRemark.setRank(rank);
			if (wantDao.save(wRemark)) {
				status = Status.success("评论成功");
			} else {
				status = Status.error("已经评论了");
			}
		}

		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());

		return map;
	}

	public Map<String, Object> saveBuyerRemark(String text, Integer pid,
			Integer uid, Integer rank) {

		Map<String, Object> map = new HashMap<>();
		Status status = null;
		text = Utils.toTrimOrNull(text);
		if (Utils.isNull(pid)) {
			status = Status.error("pid为空");
		} else if (Utils.isNull(uid)) {
			status = Status.error("uid为空");
		} else if (Utils.isNull(rank)||rank==0) {
			status = Status.error("评分为空");
		}else if (Utils.isNull(text)) {
			status = Status.error("评论为空");
		} else {
			BuyerRemark buyerRemark = new BuyerRemark();
			buyerRemark.setPK(new RemarkPK(pid, uid));
			buyerRemark.setText(text);
			buyerRemark.setTime(new Date());
			buyerRemark.setRank(rank);
			if (buyerDao.save(buyerRemark)) {
				status = Status.success("评论成功");
			} else {
				status = Status.error("已经评论了");
			}
		}

		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());

		return map;
	}

	public Map<String, Object> checkWanterRemark(Integer id, Integer uid) {

		Map<String, Object> map = new HashMap<>();
		boolean res=wantDao.check(id,uid);
		map.put(NameInfo.status, res);
		return map;
	}

	public Map<String, Object> checkBuyerRemark(Integer id, Integer uid) {

		Map<String, Object> map = new HashMap<>();
		boolean res=buyerDao.check(id,uid);
		map.put(NameInfo.status, res);
		return map;
	}

}
