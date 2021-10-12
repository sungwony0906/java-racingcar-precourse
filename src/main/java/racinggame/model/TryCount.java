package racinggame.model;

public class TryCount {

    private int tryCount;

    public TryCount(String tryCount) throws IllegalArgumentException{
        try {
            this.tryCount = Integer.parseInt(tryCount);
            if(this.tryCount < 0)
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 0보다 커야합니다");
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
    }

    public int getTryCount(){
        return tryCount;
    }
}
