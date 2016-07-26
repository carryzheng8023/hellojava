package com.zhengxin.database.mongodb;

import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;

import java.util.ArrayList;

import static org.bson.assertions.Assertions.notNull;

/**
 * 支持ArrayList的Codec
 */
@SuppressWarnings("rawtypes")
public class ArrayListCodec implements Codec<ArrayList> {
	private final CodecRegistry codecRegistry;

	/**
	 * Construct an instance with the given registry
	 *
	 * @param codecRegistry
	 *            the codec registry
	 */
	public ArrayListCodec(final CodecRegistry codecRegistry) {
		this.codecRegistry = notNull("codecRegistry", codecRegistry);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void encode(BsonWriter writer, ArrayList arrayList, EncoderContext encoderContext) {
		writer.writeStartArray();

		for (Object value : arrayList) {
			Codec codec = codecRegistry.get(value.getClass());
			encoderContext.encodeWithChildContext(codec, writer, value);
		}

		writer.writeEndArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList decode(BsonReader reader, DecoderContext decoderContext) { // TOOD 此方法未测试...
		reader.readStartArray();

		ArrayList list = new ArrayList();
		while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
			BsonType bsonType = reader.getCurrentBsonType();
			Codec codec = codecRegistry.get(MongoClients.bsonTypeClassMap.get(bsonType));
			if (null == codec) {
				throw new RuntimeException("Can't find a codec for " + bsonType);
			}
			list.add(codec.decode(reader, decoderContext));
		}

		reader.readEndArray();

		return list;
	}

	@Override
	public Class<ArrayList> getEncoderClass() {
		return ArrayList.class;
	}

}
