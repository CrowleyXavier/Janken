package application;

import java.util.Random;

import game.Battle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FormController {
    @FXML private Button button_OK;
    @FXML private Button button_Rock;
    @FXML private Button button_Scissors;
    @FXML private Button button_Paper;
    @FXML private Button button_Reset;
    @FXML private Label label_text;
    @FXML private Label label_kekka;
    @FXML private ImageView image_player;
    @FXML private ImageView image_enemy;

    private Battle battle= new Battle();

    private final Image Woman=new Image("pic/Woman.png");
    private final Image Man=new Image("pic/Man.png");
    private final Image ROCK= new Image("pic/Rock.png");
    private final Image SCISSORS= new Image("pic/Scissors.png");
    private final Image PAPER= new Image("pic/Paper.png");

    private int hand_player;
    private int hand_enemy;
    private int result; //じゃんけんの結果をintで保有

    private Random rand= new Random(); //相手の出す手をランダムに生成

    //勝敗の記録
    int win=0;
    int lose=0;
    int draw=0;

//  進行状況1(じゃんけんの入力待機)以外のときに、進行状況を進める
    @FXML
    public void onOKClicked() {
        if(battle.getPhase() != 1){
        battle.nextPhase();
        draw();
        }
    }
    @FXML
    public void onRockClicked() {
        if(battle.getPhase() == 1) {
        hand_player= 1;
        hand_enemy= rand.nextInt(3)+ 1;
        result= battle.battle(hand_player, hand_enemy, battle.getPhase());
        battle.nextPhase();
        draw();
        }
    }
    @FXML
    public void onScissorsClicked() {
        if(battle.getPhase() == 1) {
        hand_player= 2;
        hand_enemy= rand.nextInt(3)+ 1;
        result= battle.battle(hand_player, hand_enemy, battle.getPhase());
        battle.nextPhase();
        draw();
        }
    }
    @FXML
    public void onPaperClicked() {
        if(battle.getPhase() == 1) {
        hand_player= 3;
        hand_enemy= rand.nextInt(3)+ 1;
        result= battle.battle(hand_player, hand_enemy, battle.getPhase());
        battle.nextPhase();
        draw();
        }
    }

    @FXML//勝敗をリセットし、初期画面に戻る
    public void onResetClicked() {

        battle.ResetPhase();
        draw();
    }

//  進行状況に応じて描画の更新をする
    public void draw() {
        switch (battle.getPhase()) {
        case 0://Home画面
        	win=0;
        	lose=0;
        	draw=0;
            label_text.setText("じゃんけんゲーム三点先取です!!");
            label_kekka.setText(win+"勝"+lose+"敗"+draw+"引き分け");
            image_player.setImage(Man);
            image_enemy.setImage(Woman);
            break;
        case 1:
            label_text.setText("さいしょはグー、じゃんけん...");
            break;
        case 2:
            image_player.setImage(changeImage(hand_player));
            image_enemy.setImage(changeImage(hand_enemy));
            switch (result) {
            case 1:
            	win++;
                label_text.setText("あなたの勝ちです！！");
                label_kekka.setText(win+"勝"+lose+"敗"+draw+"引き分け");
                if(win==3) {//三勝するとWin画面に遷移する
                	new Main().changeView("Win.fxml");
                	win=0;
                	lose=0;
                	draw=0;
                }
                break;
            case 2:
            	lose++;
                label_text.setText("あなたの負けです...");
                label_kekka.setText(win+"勝"+lose+"敗"+draw+"引き分け");
                if(lose==3) {//三敗するとLose画面に遷移する
                	new Main().changeView("Lose.fxml");
                	win=0;
                	lose=0;
                	draw=0;
                }
                break;
            case 3:
            	draw++;
                label_text.setText("あいこです！");
                label_kekka.setText(win+"勝"+lose+"敗"+draw+"引き分け");
                break;

            default:
                break;
            }
            break;

        default:
            break;
        }
    }

//  じゃんけんの手の画像の更新をする
    private Image changeImage(int hand) {
        switch (hand) {
        case 1:
            return ROCK;
        case 2:
            return PAPER;
        case 3:
            return SCISSORS;
        default:
            return ROCK; //例外処理
        }
    }

}
