package eu.mshade.mwork.nametag.buffer;

import eu.mshade.mwork.nametag.BinaryTag;
import eu.mshade.mwork.nametag.NameTagBuffer;
import eu.mshade.mwork.nametag.NameTagBufferDriver;
import eu.mshade.mwork.nametag.entity.IntegerArrayBinaryTag;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class IntegerArrayBinaryTagBuffer implements NameTagBuffer {

    @Override
    public void write(NameTagBufferDriver nameTagBufferDriver, DataOutputStream outputStream, BinaryTag<?> binaryTag) throws Exception {
        IntegerArrayBinaryTag integerArrayBinaryTag = (IntegerArrayBinaryTag) binaryTag;
        int[] ints = integerArrayBinaryTag.getValue();
        outputStream.writeInt(ints.length);
        for (int anInt : ints) {
            outputStream.writeInt(anInt);
        }
    }

    @Override
    public IntegerArrayBinaryTag read(NameTagBufferDriver nameTagBufferDriver, DataInputStream inputStream) throws Exception {
        int length = inputStream.readInt();
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = inputStream.readInt();
        }
        return new IntegerArrayBinaryTag(ints);
    }
}
