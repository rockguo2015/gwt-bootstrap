/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.TextBoxBase;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A TextBox for Bootstrap form.
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * @author ohashi keisuke
 * 
 */
public class TextBox extends TextBoxBase {

	/**
	 * Creates a TextBox widget that wraps an existing &lt;input type='text'&gt;
	 * element.
	 * 
	 * This element must already be attached to the document. If the element is
	 * removed from the document, you must call
	 * {@link RootPanel#detachNow(Widget)}.
	 * 
	 * @param element
	 *            the element to be wrapped
	 */
	public static TextBox wrap(Element element) {
		// Assert that the element is attached.
		assert Document.get().getBody().isOrHasChild(element);

		TextBox textBox = new TextBox(element);

		// Mark it attached and remember it for cleanup.
		textBox.onAttach();
		RootPanel.detachOnWindowClose(textBox);

		return textBox;
	}

	/**
	 * Creates an empty text box.
	 */
	public TextBox() {
		this(Document.get().createTextInputElement(), "gwt-TextBox");
	}

	/**
	 * This constructor may be used by subclasses to explicitly use an existing
	 * element. This element must be an &lt;input&gt; element whose type is
	 * 'text'.
	 * 
	 * @param element
	 *            the element to be used
	 */
	protected TextBox(Element element) {
		super(element);
		assert InputElement.as(element).getType().equalsIgnoreCase("text");
	}

	TextBox(Element element,
		String styleName) {
		super(element);
		if (styleName != null) {
			setStyleName(styleName);
		}
	}

	/**
	 * Gets the maximum allowable length of the text box.
	 * 
	 * @return the maximum length, in characters
	 */
	public int getMaxLength() {
		return getInputElement().getMaxLength();
	}

	/**
	 * Gets the number of visible characters in the text box.
	 * 
	 * @return the number of visible characters
	 */
	public int getVisibleLength() {
		return getInputElement().getSize();
	}

	/**
	 * Sets the maximum allowable length of the text box.
	 * 
	 * @param length
	 *            the maximum length, in characters
	 */
	public void setMaxLength(int length) {
		getInputElement().setMaxLength(length);
	}

	/**
	 * Sets the number of visible characters in the text box.
	 * 
	 * @param length
	 *            the number of visible characters
	 */
	public void setVisibleLength(int length) {
		getInputElement().setSize(length);
	}

	private InputElement getInputElement() {
		return getElement().cast();
	}

}
