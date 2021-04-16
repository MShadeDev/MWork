package eu.mshade.mwork.nametag.buffer;

import eu.mshade.mwork.nametag.BinaryTag;
import eu.mshade.mwork.nametag.NameTagBuffer;
import eu.mshade.mwork.nametag.NameTagBufferDriver;
import eu.mshade.mwork.nametag.entity.LongArrayBinaryTag;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class LongArrayBinaryTagBuffer implements NameTagBuffer {

    @Override
    public void write(NameTagBufferDriver nameTagBufferDriver, DataOutputStream outputStream, BinaryTag<?> binaryTag) throws Exception {
        LongArrayBinaryTag longArrayBinaryTag = (LongArrayBinaryTag) binaryTag;
        long[] longs = longArrayBinaryTag.getValue();
        outputStream.writeInt(longs.length);
        for (long l : longs) {
            outputStream.writeLong(l);
        }
    }

    @Override
    public LongArrayBinaryTag read(NameTagBufferDriver nameTagBufferDriver, DataInputStream inputStream) throws Exception {
        int length = inputStream.readInt();
        long[] longs = new long[length];
        for (int i = 0; i < length; i++) {
            longs[i] = inputStream.readLong();
        }
        return new LongArrayBinaryTag(longs);
    }

}
