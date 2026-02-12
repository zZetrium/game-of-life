/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zetrium.gameoflife;

import com.badlogic.gdx.math.Vector2;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xzidek
 */
public class World {

    public static final int DEFAULT_CHUNK_SIZE = 16;
    private final int chunkSize;
    private Map<ChunkPos, boolean[][]> map = new HashMap();

    public void put(Point pos, boolean value) {
        var chunkPos = new ChunkPos(pos, chunkSize);
        var chunk = map.get(chunkPos);
        if (chunk == null) {
            chunk = new boolean[chunkSize][chunkSize];
            map.put(chunkPos, chunk);
        }
        int chunkX = pos.x - chunkPos.x() * chunkSize;
        int chunkY = pos.y - chunkPos.y() * chunkSize;
        chunk[chunkX][chunkY] = value;
    }

    public boolean get(Point pos) {
        var chunkPos = new ChunkPos(pos, chunkSize);
        var chunk = map.get(chunkPos);
        if (chunk == null) {
            return false;
        }
        int chunkX = pos.x - chunkPos.x() * chunkSize;
        int chunkY = pos.y - chunkPos.y() * chunkSize;
        return chunk[chunkX][chunkY];
    }

    public World(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    public int getChunkSize() {
        return chunkSize;
    }

}
