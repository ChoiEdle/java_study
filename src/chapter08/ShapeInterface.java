package chapter08;
/**
 * 추상 메소드들을 모아 놓은 그룹
 */
public interface ShapeInterface {
	public void draw();			//기본적으로 추상 메소드들을 모아 놓는 그룹이라 abstract을 안붙여도 추상 메소드로 인식함
	public double getArea();
	
}
