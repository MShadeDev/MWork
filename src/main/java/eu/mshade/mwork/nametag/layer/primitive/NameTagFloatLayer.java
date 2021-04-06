package eu.mshade.mwork.nametag.layer.primitive;


import eu.mshade.mwork.nametag.NameTagAdaptor;
import eu.mshade.mwork.nametag.NameTagDriver;
import net.kyori.adventure.nbt.BinaryTag;
import net.kyori.adventure.nbt.FloatBinaryTag;


public class NameTagFloatLayer implements NameTagAdaptor<Float> {

    @Override
    public Float deserialize(NameTagDriver nameTagDriver, Class<?> aClass, BinaryTag tag) {
        FloatBinaryTag floatTag = (FloatBinaryTag) tag;
        return floatTag.value();
    }

    @Override
    public BinaryTag serialize(NameTagDriver nameTagDriver, Float aFloat) {
        return FloatBinaryTag.of(aFloat);
    }
}
