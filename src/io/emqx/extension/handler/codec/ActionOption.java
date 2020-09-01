package io.emqx.extension.handler.codec;

import java.util.ArrayList;
import java.util.List;

import com.erlport.erlang.term.Atom;
import com.erlport.erlang.term.Binary;
import com.erlport.erlang.term.Tuple;

public class ActionOption implements Tupleable {
	
	final String key;
	final List<String> values;
	
	public ActionOption(String key, List<String> values) {
		this.key = key;
		this.values = values;
	}
	

	@Override
	public Tuple toTuple() {
		List<Binary> vals = new ArrayList<>();
		for (String value : values) {
			vals.add(new Binary(value));
		}
		
		return Tuple.two(new Atom(key), vals);
	}
}
