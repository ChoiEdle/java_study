package com.scoremgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.scoremgm.model.Member;

public class ScoreServiceImpl implements ScoreService {
	//Field
	Scanner scan;
	//Constructor
	public ScoreServiceImpl() {
		
	}
	public ScoreServiceImpl(Scanner scan) {
		this.scan = scan;
	}
	
	//Method
	public void register() {
		List memberInfo = createMemberInfo();

		//Member 생성
		Member member = new Member();
		member.setNo((String)memberInfo.get(0));
		member.setName((String)memberInfo.get(1));
		member.setDepartment((String)memberInfo.get(2));
		member.setKor((int)memberInfo.get(3));
		member.setEng((int)memberInfo.get(4));
		member.setMath((int)memberInfo.get(5));
		
		//저장소 등록을 위한 Repository 호출
		
		
		
//		System.out.println(member.getNo());
//		System.out.println(member.getName());
//		System.out.println(member.getDepartment());
//		System.out.println(member.getKor());
//		System.out.println(member.getEng());
//		System.out.println(member.getMath());
		
	}
	
	public void list() {
		
	}
	
	public void search() {
		
	}
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
	
	public void exit() {
		
	}
	
	/**
	 * 학생 정보 임시 저장 객체 생성
	 * @return List
	 */
	public List createMemberInfo() {
		String[] labels = {"학생명", "전공", "국어", "영어", "수학"};		//뒤에 과목이 더 늘어도 코드가 늘어나진 않음
		List memberInfo = new ArrayList();
		Random rd = new Random();
		String no = "2025-" + rd.nextInt(1000, 9999);		//학번 생성
		memberInfo.add(no);
		
		for(int i=0; i<labels.length; i++) {
			if(i>=2) {
				//i = 2, 3, 4
				System.out.print(labels[i] + " > ");
				memberInfo.add(scan.nextInt());
			} else {
				//i = 0, 1
				System.out.print(labels[i] + " > ");
				memberInfo.add(scan.next());
			}
		}
		
		
		return memberInfo;
	}
}
