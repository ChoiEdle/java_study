package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.scoremgm.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository {
	//Field
	List<Member> storage = new ArrayList<Member>();
	
	//ConStructor
	
	//Method
	@Override
	public boolean insert(Member member) {
		if(member == null) {
			return false;
		}
		return storage.add(member);
	}
	
	@Override
	public int getCount() {
		return storage.size();
	}
	
	@Override
	public List<Member> findAll(){
		return storage;
	}
	
	@Override
	public Member find(String no) {
		no = "2025-" + no;
		Member member = null;
		
		if(no != null) {
			for(Member m : storage) {
				if(m.getNo().equals(no)) {
					member = m;
				}
			}
		}
		
		return member;
		
//		int idx = -1;
//		for(int i=0; i<storage.size(); i++) {
//			if(storage.get(i).getNo().equals(no)) {
//				idx = i;
//			}
//		}
//		
//		Member result = storage.get(idx);
//		return result;
	}
	
	@Override
	public void update(Member member) {
		int idx = -1;
		for(int i=0; i<storage.size(); i++) {
			Member m = storage.get(i);
			if(m.getNo().equals(member.getNo())) {
				idx = i;
				break;
			}
		}
//		idx = storage.indexOf(member);		//내 예상데로 index찾아주는 메소드 맞음
		
		storage.set(idx, member);
	}
	
	@Override
	public void remove(String no) {
		no = "2025-" + no;
		Iterator<Member> ie = storage.iterator();
		while(ie.hasNext()) {
			Member member = ie.next();
			if(member.getNo().equals(no)) {
				ie.remove();
				break;
			}
		}
	}
}
