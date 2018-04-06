//657. Judge Route Circle (Robot) (easy)


public class JudgeRoutCircleRobot {

    static public void main(String[] args) {
        JudgeRoutCircleRobot judgeRoutCircleRobot = new JudgeRoutCircleRobot();
        System.out.println(judgeRoutCircleRobot.judgeCircle("LLRR"));
    }

    public boolean judgeCircle(String moves) {
        int[] position = {0, 0};
        for (int i=0; i< moves.length(); i++) {
            char ch = moves.charAt(i);  //mov.charAt(i) mov.substring(i,i+1)
            switch(ch) {
                case 'U': position[1]++;
                    break;
                case 'D': position[1]--;
                    break;
                case 'L': position[0]--;
                    break;
                case 'R': position[0]++;
                    break;
            }
        }
        return position[0] == 0 && position[1] == 0;
    }

}
