package com.scoremgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.scoremgm.app.ScoreMgmSystem;
import com.scoremgm.model.MemberVo;
import com.scoremgm.repository.ScoreRepositoryImpl;

import db.GenericRepositoryInterface;

public class ScoreServiceImpl implements ScoreService {
	//Field
	Scanner scan;
	ScoreMgmSystem sms;
	GenericRepositoryInterface<MemberVo> repository = new ScoreRepositoryImpl();
	
	//Constructor
	public ScoreServiceImpl() {
		
	}
	public ScoreServiceImpl(ScoreMgmSystem sms) {
		this.sms = sms;
		this.scan = sms.scan;
	}
	
	//Method
	/**
	 * 학생정보 저장소(storage)의 갯수 가져오기
	 */
	@Override
	public int getCount() {
		return repository.getCount();
	}
	
	/**
	 * 학생 등록
	 */
	@Override
	public void register() {
		List memberInfo = createMemberInfo();

		//Member 생성
		MemberVo member = new MemberVo();
//		member.setNo((String)memberInfo.get(0));
		member.setName((String)memberInfo.get(0));
		member.setDepartment((String)memberInfo.get(1));
		member.setKor((int)memberInfo.get(2));
		member.setEng((int)memberInfo.get(3));
		member.setMath((int)memberInfo.get(4));
		
		//저장소 등록을 위한 Repository 호출
		if(repository.insert(member) == 1) {
			//성공
			System.out.println("=> 등록 완료!!!");
		} else {
			//실패
			System.out.println("=> 등록 실패!!!");
		}
		
		//메뉴 호출
		sms.showMenu();
		sms.selectMenu();
	}
	
	/**
	 * 조회
	 */
	@Override
	public void list() {
		if(getCount() != 0) {
			List<MemberVo> list = repository.findAll();
			System.out.println("====================================================");
			System.out.println("번호\t학번\t이름\t전공\t국어\t영어\t수학\t날짜");
			System.out.println("====================================================");
			list.forEach((member) -> {
				System.out.print(member.getRno() + " \t");
				System.out.print(member.getMid() + " \t");
				System.out.print(member.getName() + " \t");
				System.out.print(member.getDepartment() + " \t");
				System.out.print(member.getKor() + " \t");
				System.out.print(member.getEng() + " \t");
				System.out.print(member.getMath() + " \t");
				System.out.print(member.getMdate() + " \n");
			});
			System.out.println("====================================================");
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
		
//		for(Member member : list) {
//			System.out.print(member.getNo() + " \t");
//			System.out.print(member.getName() + " \t");
//			System.out.print(member.getDepartment() + " \t");
//			System.out.print(member.getKor() + " \t");
//			System.out.print(member.getEng() + " \t");
//			System.out.print(member.getMath() + " \n");
//		}
	}
	
	/**
	 * 검색 : 학번 기준
	 */
	@Override		
	public void search() {
		if(getCount() != 0) {
			System.out.print("학번 > ");
			String mid = scan.next();
			MemberVo member = repository.find(mid);
			
			if(member != null) {
				System.out.println("====================================================");
				System.out.println("=> 검색 결과");
				System.out.println("====================================================");
				System.out.println("학번\t이름\t전공\t국어\t영어\t수학\t날짜");
				System.out.println("====================================================");
				System.out.print(member.getMid() + " \t");
				System.out.print(member.getName() + " \t");
				System.out.print(member.getDepartment() + " \t");
				System.out.print(member.getKor() + " \t");
				System.out.print(member.getEng() + " \t");
				System.out.print(member.getMath() + " \t");
				System.out.print(member.getMdate() + " \n");
				System.out.println("====================================================");
			} else {
				System.out.println("=> 학생 정보 없음!!");
			}
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
	}
	
	/**
	 * 수정
	 */
	@Override
	public void update() {
		if(getCount() != 0) {
			System.out.print("학번 > ");
			String mid = scan.next();
			MemberVo member = repository.find(mid);			//학생 정보 - old
			
			if(member != null) {
				//수정할 학생 정보 입력!! 학번 제외
				List memberInfo = createMemberInfo(member);
				member.setKor((int)memberInfo.get(0));
				member.setEng((int)memberInfo.get(1));
				member.setMath((int)memberInfo.get(2));
				
				//storage에 member 업데이트
				repository.update(member);
				
				System.out.println("====================================================");
				System.out.println("=> 수정 결과");
				System.out.println("====================================================");
				System.out.println("학번\t이름\t전공\t국어\t영어\t수학");
				System.out.println("====================================================");
				System.out.print(member.getMid() + " \t");
				System.out.print(member.getName() + " \t");
				System.out.print(member.getDepartment() + " \t");
				System.out.print(member.getKor() + " \t");
				System.out.print(member.getEng() + " \t");
				System.out.print(member.getMath() + " \n");
			} else {
				System.out.println("=> 학생 정보 없음!!");
			}
			System.out.println("====================================================");
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
		
	}
	
	/**
	 * 삭제
	 */
	@Override
	public void delete() {
		if(getCount() != 0) {
			System.out.print("학번 > ");
			String mid = scan.next();
			MemberVo member = repository.find(mid);			//학생 정보 - old
			
			if(member != null) {
				//정말로 삭제 진행 여부 확인!!
				System.out.println("정말로 삭제하시겠습니까?(y:삭제, 아무키:취소)");
				if(scan.next().equals("y")) {
					repository.remove(mid);
					System.out.println("=> 삭제 완료");
				}
			} else {
				System.out.println("=> 학생 정보 없음!!");
			}
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
	}
	
	/**
	 * 종료
	 */
	@Override
	public void exit() {
		System.out.println("=> 프로그램 종료!!");
		repository.close();
		System.exit(0);
	}
	
	/**
	 * 학생 정보 임시 저장 객체 생성
	 * @return List
	 */
	public List createMemberInfo() {
		String[] labels = {"학생명", "전공", "국어", "영어", "수학"};		//뒤에 과목이 더 늘어도 코드가 늘어나진 않음
		List memberInfo = new ArrayList();
		
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
	
	/**
	 * 학생 정보 임시 저장 객체 수정
	 * @param no 학번
	 * @return List
	 */
	public List createMemberInfo(MemberVo member) {
		String[] labels = {"국어", "영어", "수학"};		//뒤에 과목이 더 늘어도 코드가 늘어나진 않음
		List memberInfo = new ArrayList();
		
//		System.out.println("학번 : " + member.getNo() + ", " + "학생명 : " + member.getName());
		
		for(int i=0; i<labels.length; i++) {
				System.out.print(labels[i] + " > ");
				memberInfo.add(scan.nextInt());
		}
		return memberInfo;
	}
	
}
