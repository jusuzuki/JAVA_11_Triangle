public class Triangle {
  private Integer mSide1;
  private Integer mSide2;
  private Integer mSide3;

  public Triangle(Integer side1, Integer side2, Integer side3) {
    mSide1 = side1;
    mSide2 = side2;
    mSide3 = side3;
  }

  public int getSide1() {
    return mSide1;
  }

  public int getSide2() {
    return mSide2;
  }

  public int getSide3() {
    return mSide3;
  }

  public boolean isTriangle(){
    return (mSide1 + mSide2) > mSide3 && (mSide2 + mSide3) > mSide1 && (mSide1 + mSide3) > mSide2;
  }

  public boolean isEquilateral(){
    return mSide1 == mSide2 && mSide2 == mSide3;
  }

  public boolean isIsosceles(){
    return mSide1 == mSide2 || mSide1 == mSide3 || mSide2 == mSide3;
  }

  public boolean isScalene(){
    return mSide1 != mSide2 && mSide1 != mSide3 && mSide2 != mSide3;
  }

}
