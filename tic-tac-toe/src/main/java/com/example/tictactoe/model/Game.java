package com.example.tictactoe.model;

import java.util.*;

public class Game {

    private final BoardManager boardManager;
    private final List<Player> players;

    private int turn = 0;
    private int filled = 0;
    private final int total;
    private final int boardSize;
    private int winnerPlayer = -1;
    private final Random random = new Random();
    private  final Map<Sign , Map<Integer , Integer>> rowData , columnData, forwardDiagonalData , backDiagonalData;
    public Game(int boardSize , int PlayerSize){
        this.boardManager = new BoardManager(boardSize);
        this.rowData = new EnumMap<>(Sign.class);
        this.columnData = new EnumMap<>(Sign.class);
        this.forwardDiagonalData = new EnumMap<>(Sign.class);
        this.backDiagonalData = new EnumMap<>(Sign.class);
        this.players = new ArrayList<>(PlayerSize);
        initializePlayers(this.players);
        total = boardSize * boardSize;
        this.boardSize = boardSize;
    }

    private void initializePlayers(List<Player> players) {
        Sign[] signs = Sign.values();
        for(int index = 0; index < signs.length; index++) {
            players.add(new Player("player - " + index , signs[index % signs.length]));
        }
    }


    public void startGame(){
        System.out.println("Starting a Game");
        while((filled < total) && winnerPlayer == -1){
            makeMove();
            doDisplayJob();
            doUpdationOfParams();
            if(winnerPlayer != -1) break;
        }
        printFinalState();
    }

    private void printFinalState() {
        if(winnerPlayer == -1){
            System.out.println("Game Over with draw");
        }
        else{
            System.out.println("Winner of Game is " + winnerPlayer);
        }
    }

    private void makeMove() {
        Sign sign = players.get(turn).getSign();
        boolean isFilled;
        do{
            isFilled = doOperationUntilPositionFilled(sign);
        }
        while(!isFilled);
    }

    private void doDisplayJob() {
        System.out.println("Displaying Board having player turn : " + turn);
        System.out.println(boardManager.getBoard());
    }

    private void doUpdationOfParams() {
        filled++;
        turn++;
        turn %= players.size();
    }

    private boolean doOperationUntilPositionFilled(Sign sign) {
        boolean isFilled;
        int x = random.nextInt(boardSize);
        int y = random.nextInt(boardSize);
        isFilled = boardManager.makeMove(x , y , sign);
        if(isFilled){
            initializeSignWiseMap(sign);
            initializePositionWiseMap(sign, y, x);
            updatePositionWiseData(sign, y, x);
            if(checkIfWinner(x , y , sign)){
                this.winnerPlayer = turn;
            }
        }
        return isFilled;
    }

    private void updatePositionWiseData(Sign sign, int y, int x) {
        rowData.get(sign).put(y, rowData.get(sign).get(y) + 1);
        columnData.get(sign).put(x, columnData.get(sign).get(x) + 1);
        forwardDiagonalData.get(sign).put(x - y, 0);
        backDiagonalData.get(sign).put(x + y, 0);
    }

    private void initializePositionWiseMap(Sign sign, int y, int x) {
        rowData.get(sign).putIfAbsent(y, 0);
        columnData.get(sign).putIfAbsent(x, 0);
        forwardDiagonalData.get(sign).putIfAbsent(x - y, 0);
        backDiagonalData.get(sign).putIfAbsent(x + y, 0);
    }

    private void initializeSignWiseMap(Sign sign) {
        rowData.putIfAbsent(sign, new HashMap<>());
        columnData.putIfAbsent(sign, new HashMap<>());
        forwardDiagonalData.putIfAbsent(sign, new HashMap<>());
        backDiagonalData.putIfAbsent(sign, new HashMap<>());
    }

    private boolean checkIfWinner(int x , int y , Sign sign) {
        return rowData.get(sign).get(y) == boardSize
                || columnData.get(sign).get(x) == boardSize
                || forwardDiagonalData.get(sign).get(x - y) == boardSize
                || backDiagonalData.get(sign).get(x + y) == boardSize;
    }


}
