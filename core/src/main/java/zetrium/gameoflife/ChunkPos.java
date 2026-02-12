/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zetrium.gameoflife;

import com.badlogic.gdx.math.Vector2;
import java.awt.Point;

/**
 *
 * @author xzidek
 */
public record ChunkPos(int x,int y) {

    public ChunkPos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public ChunkPos(Point fieldPos,int chunkSize) {
        this((int)fieldPos.x/chunkSize,(int)fieldPos.y/chunkSize);
    }
}
