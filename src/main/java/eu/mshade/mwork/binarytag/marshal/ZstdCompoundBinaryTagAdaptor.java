package eu.mshade.mwork.binarytag.marshal;

import eu.mshade.mwork.binarytag.BinaryTag;
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag;

import java.lang.reflect.Type;

public class ZstdCompoundBinaryTagAdaptor extends CompoundBinaryTagAdaptor{

    @Override
    public BinaryTag<?> serialize(BinaryTagMarshal binaryTagMarshal, Type type, Object o) throws Exception {
        return ((CompoundBinaryTag) super.serialize(binaryTagMarshal, type, o)).toZstd();
    }
}
