package com.mk.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mk.dao.impl.RemarkDao;
import com.mk.entity.Remark;
import com.mk.entity.Phone;
import com.mk.entity.RemarkPK;
import com.mk.info.NameInfo;
import com.mk.info.MsgInfo.Login;
import com.mk.info.status.Status;
import com.mk.util.Utils;
@Transactional
@org.springframework.stereotype.Service
public class RemarkService {


	@Autowired
	private RemarkDao remarkDao;



	public Map<String, Object> getRemark(Integer id, Integer start,
			Integer limit) {
		List<Map<String, Object>> wList = null;

		if (Utils.isNull(id) || Utils.isNull(start) || Utils.isNull(limit))
			return null;

		wList = remarkDao.list(id, start, limit);
		Map<String, Object> map=new HashMap<>();
		map.put("size", remarkDao.size());
		map.put("list", wList);
		return map;
	}


	public Map<String, Object> saveRemark(String text, Integer pid,
			Integer uid, Integer rank,int type) {

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
			Remark remark = new Remark();
			remark.setPK(new RemarkPK(pid, uid));
			remark.setText(text);
			remark.setTime(new Date());
			remark.setRank(rank);
			remark.setType(type);
			
			if (remarkDao.save(remark)) {
				status = Status.success("评论成功");
			} else {
				status = Status.error("已经评论了");
			}
		}

		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());

		return map;
	}

	

	public Map<String, Object> checkRemark(Integer id, Integer uid) {

		Map<String, Object> map = new HashMap<>();
		boolean res=remarkDao.check(id,uid);
		map.put(NameInfo.status, res);
		return map;
	}


	public Map<String, Object> getRemarkRange(Integer pid) {
		

		if (Utils.isNull(pid))
			return null;

		return remarkDao.getRemakRange(pid);
	}

}
