package com.example.tappyspaceship01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine extends SurfaceView implements Runnable {

    // Android debug variables
    final static String TAG = "DINO-RAINBOWS";

    // screen size
    int screenHeight;
    int screenWidth;

    // game state
    boolean gameIsRunning;

    // threading
    Thread gameThread;


    // drawing variables
    SurfaceHolder holder;
    Canvas canvas;
    Paint paintbrush;
    int playerXposition;
    int playerYposition;


    Bitmap playerImage;
    Bitmap candyImage;
    Bitmap garbageImage;
    Bitmap ranbow;

    int candyXposition;
    int candyYposition;

    int garbageXposition;
    int garbageYposition;

    int ranbowXposition;
    int ranbowYposition;

    Rect playerHitbox;
    Rect candyHitbox;
    Rect garbageHitbow;
    Rect ranbowHitbox;


    // -----------------------------------
    // GAME SPECIFIC VARIABLES
    // -----------------------------------

    // ----------------------------
    // ## SPRITES
    // ----------------------------

    // represent the TOP LEFT CORNER OF THE GRAPHIC

    // ----------------------------
    // ## GAME STATS
    // ----------------------------


    public GameEngine(Context context, int w, int h) {
        super(context);

        this.holder = this.getHolder();
        this.paintbrush = new Paint();

        this.screenWidth = w;
        this.screenHeight = h;

        this.printScreenInfo();


// @TODO: Add your sprites

        // put initial starting postion of candy
        this.candyImage = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.candy64);
        this.candyXposition = 1300;
        this.candyYposition = 120;
        // 1. create the hitbox
        this.candyHitbox = new

                Rect(1300,
                120,
                1300 + candyImage.getWidth(),
                120 + candyImage.getHeight()
        );
        // put initial starting postion of garbage

        this.candyImage = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.poop64);
        this.candyXposition = 1300;
        this.candyYposition = 220;
        // 1. create the hitbox
        this.candyHitbox = new

                Rect(1300,
                120,
                1300 + candyImage.getWidth(),
                220 + candyImage.getHeight()
        );

        // put initial starting postion of ranbow
        this.candyImage = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.rainbow64);
        this.candyXposition = 1300;
        this.candyYposition = 320;
        // 1. create the hitbox
        this.candyHitbox = new

                Rect(1300,
                120,
                1300 + candyImage.getWidth(),
                320 + candyImage.getHeight()
        );


        // put the initial starting position of your player

        this.playerImage = BitmapFactory.decodeResource(this.

                        getContext().

                        getResources(),

                R.drawable.dino64);
        this.playerXposition = 100;
        this.playerYposition = 600;

        this.playerHitbox = new

                Rect(100,
                600,
                100 + playerImage.getWidth(),
                600 + playerImage.getHeight()
        );
    }



    private void printScreenInfo() {

        Log.d(TAG, "Screen (w, h) = " + this.screenWidth + "," + this.screenHeight);
    }



    private void spawnPlayer() {
        //@TODO: Start the player at the left side of screen
    }
    private void spawnEnemyShips() {
        Random random = new Random();

        //@TODO: Place the enemies in a random location

    }

    // ------------------------------
    // GAME STATE FUNCTIONS (run, stop, start)
    // ------------------------------
    @Override
    public void run() {
        while (gameIsRunning == true) {
            this.updatePositions();
            this.redrawSprites();
            this.setFPS();
        }
    }


    public void pauseGame() {
        gameIsRunning = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            // Error
        }
    }

    public void startGame() {
        gameIsRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }


    // ------------------------------
    // GAME ENGINE FUNCTIONS
    // - update, draw, setFPS
    // ------------------------------

    public void updatePositions() {


    }

    public void redrawSprites() {
        if (this.holder.getSurface().isValid()) {
            this.canvas = this.holder.lockCanvas();

            //----------------

            // configure the drawing tools
            this.canvas.drawColor(Color.argb(255,255,255,255));
            paintbrush.setColor(Color.WHITE);


            // DRAW THE PLAYER HITBOX
            // ------------------------
            // 1. change the paintbrush settings so we can see the hitbox
            paintbrush.setColor(Color.BLUE);
            paintbrush.setStyle(Paint.Style.STROKE);
            paintbrush.setStrokeWidth(5);

            //----------------
            this.holder.unlockCanvasAndPost(canvas);
        }
    }

    public void setFPS() {
        try {
            gameThread.sleep(120);
        }
        catch (Exception e) {

        }
    }

    // ------------------------------
    // USER INPUT FUNCTIONS
    // ------------------------------


    String fingerAction = "";

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int userAction = event.getActionMasked();
        //@TODO: What should happen when person touches the screen?
        if (userAction == MotionEvent.ACTION_DOWN) {

        }
        else if (userAction == MotionEvent.ACTION_UP) {

        }

        return true;
    }
}