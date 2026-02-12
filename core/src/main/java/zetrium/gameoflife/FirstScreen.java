package zetrium.gameoflife;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class FirstScreen implements Screen {

    ShapeRenderer filled;
    ShapeRenderer lines;

    Viewport viewport;
    Camera cam;

    int x;
    int y;
    int displaySize = 2;

    @Override
    public void show() {
        filled = new ShapeRenderer();
        lines = new ShapeRenderer();

        viewport = new ExtendViewport(30, 20);
        cam = viewport.getCamera();
    }

    @Override
    public void render(float delta) {
        logic(delta);
        draw(delta);
    }

    private void logic(float delta) {

    }

    private void draw(float delta) {
        ScreenUtils.clear(Color.BLACK);
        filled.setProjectionMatrix(viewport.getCamera().combined);
        lines.setProjectionMatrix(viewport.getCamera().combined);
        lines.setColor(Color.WHITE);
        filled.setColor(Color.RED);

        lines.begin(ShapeRenderer.ShapeType.Line);

        filled.begin(ShapeRenderer.ShapeType.Filled);
        x = (int) (cam.position.x - viewport.getWorldWidth() / 2f);
        y = (int) (cam.position.y - viewport.getWorldHeight() / 2f);
        {
            for (int i = x; i < x + viewport.getWorldWidth() / (float) 1; i++) {
                for (int j = y; j < y + viewport.getWorldHeight() / (float) 1; j++) {
                    filled.rect(i * displaySize, j * displaySize, displaySize, displaySize);
                    lines.rect(i * displaySize, j * displaySize, displaySize, displaySize);
                }
            }
        }
        filled.end();
        lines.end();
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if (width <= 0 || height <= 0) {
            return;
        }
        viewport.update(width, height);
        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }

}
