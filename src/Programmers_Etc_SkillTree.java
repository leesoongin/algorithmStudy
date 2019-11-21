public class Programmers_Etc_SkillTree {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_tree = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skill_tree));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int checkIndex;
        boolean isCheck;
        for (int i = 0; i < skill_trees.length; i++) {
            checkIndex = 0;
            isCheck = true;

            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (checkIndex == skill.indexOf(skill_trees[i].charAt(j))) {//순서대로 잘 나오고 있다면
                    checkIndex++; //다음 순서의 index로 넘어가기.
                } else if (checkIndex < skill.indexOf(skill_trees[i].charAt(j))) {
                    isCheck = false;
                    break;
                }
            }//inner for

            if (isCheck) {//만약 순서대로 들어갔다면
                answer++;
            }
        }//for


        return answer;
    }
}
