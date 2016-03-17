package com.example.mrhappyyy.arkanoid;

/**
 * Created by mrhappyyy on 09.03.16.
 */
public interface ICanvasView {

    void drawBlock(SimpleBlock block);

    void drawCircle(SimpleCircle circle);

    void redraw();

    void showMessage(String text);
}
