package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.scoremgm.model.MemberVo;

import db.DBConn;
import db.GenericRepositoryInterface;

public class ScoreRepositoryImpl extends DBConn implements GenericRepositoryInterface<MemberVo> {
	//Field
	
	
	//ConStructor
	public ScoreRepositoryImpl() {
		super();
	}
	
	//Method
	@Override
	public boolean insert(MemberVo member) {
		if(member == null) {
			return false;
		}
		return storage.add(member);
	}
	
//	@Override
//	public int getCount() {
//		return storage.size();
//	}
//	
//	@Override
//	public List<MemberVo> findAll(){
//		return storage;
//	}
//	
//	@Override
//	public MemberVo find(String no) {
//		no = "2025-" + no;
//		MemberVo member = null;
//		
//		if(no != null) {
//			for(MemberVo m : storage) {
//				if(m.getNo().equals(no)) {
//					member = m;
//				}
//			}
//		}
//		
//		return member;
//		
////		int idx = -1;
////		for(int i=0; i<storage.size(); i++) {
////			if(storage.get(i).getNo().equals(no)) {
////				idx = i;
////			}
////		}
////		
////		Member result = storage.get(idx);
////		return result;
//	}
//	
//	@Override
//	public void update(MemberVo member) {
//		int idx = -1;
//		for(int i=0; i<storage.size(); i++) {
//			MemberVo m = storage.get(i);
//			if(m.getNo().equals(member.getNo())) {
//				idx = i;
//				break;
//			}
//		}
////		idx = storage.indexOf(member);		//내 예상데로 index찾아주는 메소드 맞음
//		
//		storage.set(idx, member);
//	}
//	
//	@Override
//	public void remove(String no) {
//		no = "2025-" + no;
//		Iterator<MemberVo> ie = storage.iterator();
//		while(ie.hasNext()) {
//			MemberVo member = ie.next();
//			if(member.getNo().equals(no)) {
//				ie.remove();
//				break;
//			}
//		}
//	}
}
