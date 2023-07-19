class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        class Node {
            boolean isObstacle;
            
            public Node(boolean isObstacle) {
                this.isObstacle = isObstacle;
            }
            
            public boolean getIsObstacle() {
                return isObstacle;
            }
        }
        
        int[] answer = {};
        int maxRow = park.length;
        int maxCol = park[0].length();
        Node[][] parkNode = new Node[maxRow][maxCol];
        int[] currentPos = new int[2];
        int[] nextPos = new int[2];
        int[] startPos = new int[2];
        
        for (int i = 0; i < park.length; i++) { //parkNode 초기화
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    startPos = new int[] {i, j};
                    parkNode[i][j] = new Node(false);
                }
                else if (park[i].charAt(j) == 'O') {
                    parkNode[i][j] = new Node(false);;
                }
                else {
                    parkNode[i][j] = new Node(true);;
                }
            }
        }
        
        currentPos = startPos;
        
        for (int j = 0; j < routes.length; j++) {
            int[] tempPos = currentPos;
            
            switch(routes[j].charAt(0)) {
                case 'N':
                    for (int i = 0; i < Integer.valueOf(routes[j].replaceAll("[^0-9]", "")); i++) {
                        if (currentPos[0] - 1 < 0) {
                            currentPos = tempPos;
                            break;
                        }
                        else if (parkNode[currentPos[0] - 1][currentPos[1]].getIsObstacle()) {
                            currentPos = tempPos;
                            break;
                        }
                        else currentPos = new int[] {currentPos[0] - 1, currentPos[1]};
                    }
                    break;
                case 'S':
                    for (int i = 0; i < Integer.valueOf(routes[j].replaceAll("[^0-9]", "")); i++) {
                        if (currentPos[0] + 1 >= maxRow) {
                            currentPos = tempPos;
                            break;
                        }
                        else if (parkNode[currentPos[0] + 1][currentPos[1]].getIsObstacle()) {
                            currentPos = tempPos;
                            break;
                        }
                        else currentPos = new int[] {currentPos[0] + 1, currentPos[1]};
                    }
                    break;
                case 'W':
                    for (int i = 0; i < Integer.valueOf(routes[j].replaceAll("[^0-9]", "")); i++) {
                        if (currentPos[1] - 1 < 0) {
                            currentPos = tempPos;
                            break;
                        }
                        else if (parkNode[currentPos[0]][currentPos[1] - 1].getIsObstacle()) {
                            currentPos = tempPos;
                            break;
                        }
                        else currentPos = new int[] {currentPos[0], currentPos[1] - 1};
                    }
                    break;
                case 'E':
                    for (int i = 0; i < Integer.valueOf(routes[j].replaceAll("[^0-9]", "")); i++) {
                        if (currentPos[1] + 1 >= maxCol) {
                            currentPos = tempPos;
                            break;
                        }
                        else if (parkNode[currentPos[0]][currentPos[1] + 1].getIsObstacle()) {
                            currentPos = tempPos;
                            break;   
                        }
                        else currentPos = new int[] {currentPos[0], currentPos[1] + 1};
                    }
                    break;
            }
        }
        answer = currentPos;
        return answer;
    }
}