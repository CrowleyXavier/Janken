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
    @FXML private Label label_text;
    @FXML private ImageView image_player;
    @FXML private ImageView image_enemy;

    private Battle battle= new Battle();
    private final Image Piece=new Image("pic/piece.jpg");
    private final Image PieceG=new Image("pic/pieceG.jpg");
    private final Image PieceP=new Image("pic/pieceP.jpg");
    private final Image PieceC=new Image("pic/pieceC.jpg");

    private final Image Sazae=new Image("pic/Sazae.jpg");
    private final Image SazaeG=new Image("pic/SazaeG.jpg");
    private final Image SazaeP=new Image("pic/SazaeP.jpg");
    private final Image SazaeC=new Image("pic/SazaeC.jpg");

    private final Image ROCK= new Image("pic/Rock.png");
    private final Image SCISSORS= new Image("pic/Scissors.png");
    private final Image PAPER= new Image("pic/Paper.png");

    private int hand_player;
    private int hand_enemy;
    private int result; //じゃんけんの結果をintで保有

    private Random rand= new Random(); //相手の出す手をランダムに生成


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

//  進行状況に応じて描画の更新をする
    public void draw() {
        switch (battle.getPhase()) {
        case 0:
            label_text.setText("じゃけんゲーム");
            image_player.setImage(Piece);
            image_enemy.setImage(Sazae);
            break;
        case 1:
            label_text.setText("さいしょはグー、じゃんけん...");
            break;
        case 2:
            image_player.setImage(PlayerchangeImage(hand_player));
            image_enemy.setImage(EnemychangeImage(hand_enemy));
            switch (result) {
            case 1:
                label_text.setText("キュアピースの勝ちです！！");
                break;
            case 2:
                label_text.setText("キュアピースの負けです...");
                break;
            case 3:
                label_text.setText("あいこです！");

            default:
                break;
            }
            break;

        default:
            break;
        }
    }

//  じゃんけんの手の画像の更新をする
    private Image PlayerchangeImage(int hand) {
        switch (hand) {
        case 1:
            return PieceG;
        case 2:
            return PieceC;
        case 3:
            return PieceP;
        default:
            return Piece; //例外
        }
    }
    private Image EnemychangeImage(int hand) {
        switch (hand) {
        case 1:
            return SazaeG;
        case 2:
            return SazaeC;
        case 3:
            return SazaeP;
        default:
            return Sazae; //例外
        }
    }
}
