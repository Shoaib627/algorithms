package com.practise.leetcode;

import java.util.Iterator;
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {

	private Iterator<Integer> iterator;

	private Integer peek;

	private boolean noSuchElement = false;

	public PeekingIterator(Iterator<Integer> iterator) {

		this.iterator = iterator;
		updatePeek();

	}

	public Integer peek() {

		if (noSuchElement) {
			throw new NoSuchElementException();
		}
		return this.peek;
	}

	@Override
	public Integer next() {

		Integer peek = peek();

		updatePeek();

		return peek;
	}

	@Override
	public boolean hasNext() {
		return !noSuchElement;
	}

	public void updatePeek() {

		if (iterator.hasNext())
			this.peek = iterator.next();
		else
			noSuchElement = true;
	}
}