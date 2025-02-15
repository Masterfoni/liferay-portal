/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

import Uri from 'metal-uri';

import globals from '../../../src/main/resources/META-INF/resources/senna/globals/globals';
import utils from '../../../src/main/resources/META-INF/resources/senna/utils/utils';

describe('utils', () => {
	beforeAll(() => {
		globals.window = {
			history: {
				pushState: 1,
			},
			location: {
				hash: '#hash',
				hostname: 'hostname',
				pathname: '/path',
				search: '?a=1',
			},
		};
	});

	afterAll(() => {
		globals.window = window;
	});

	it('copies attributes from source node to target node', () => {
		var nodeA = document.createElement('div');
		nodeA.setAttribute('a', 'valueA');
		nodeA.setAttribute('b', 'valueB');

		var nodeB = document.createElement('div');
		utils.copyNodeAttributes(nodeA, nodeB);

		expect(nodeA.attributes.length).toBe(nodeB.attributes.length);
		expect(nodeA.getAttribute('a')).toBe(nodeB.getAttribute('a'));
		expect(nodeA.getAttribute('b')).toBe(nodeB.getAttribute('b'));
		expect(nodeB.getAttribute('a')).toBe('valueA');
		expect(nodeB.getAttribute('b')).toBe('valueB');
	});

	it('clears attributes from a given node', () => {
		var node = document.createElement('div');
		node.setAttribute('a', 'valueA');
		node.setAttribute('b', 'valueB');

		utils.clearNodeAttributes(node);

		expect(node.getAttribute('a')).toBeNull();
		expect(node.getAttribute('b')).toBeNull();
		expect(node.attributes.length).toBe(0);
	});

	it('gets path from url', () => {
		expect(utils.getUrlPath('http://hostname/path?a=1#hash')).toBe(
			'/path?a=1#hash'
		);
	});

	it('gets path from url excluding hashbang', () => {
		expect(
			utils.getUrlPathWithoutHash('http://hostname/path?a=1#hash')
		).toBe('/path?a=1');
	});

	it('gets path from url excluding hashbang and search', () => {
		expect(
			utils.getUrlPathWithoutHashAndSearch(
				'http://hostname/path?a=1#hash'
			)
		).toBe('/path');
	});

	it('tests if path is current browser path', () => {
		expect(
			utils.isCurrentBrowserPath('http://hostname/path?a=1')
		).toBeTruthy();
		expect(
			utils.isCurrentBrowserPath('http://hostname/path?a=1#hash')
		).toBeTruthy();
		expect(
			!utils.isCurrentBrowserPath('http://hostname/path1?a=1')
		).toBeTruthy();
		expect(
			!utils.isCurrentBrowserPath('http://hostname/path1?a=1#hash')
		).toBeTruthy();
		expect(!utils.isCurrentBrowserPath()).toBeTruthy();
	});

	it('gets current browser path', () => {
		expect(utils.getCurrentBrowserPath()).toBe('/path?a=1#hash');
	});

	it('gets current browser path excluding hashbang', () => {
		expect(utils.getCurrentBrowserPathWithoutHash()).toBe('/path?a=1');
	});

	it('tests if Html5 history is supported', () => {
		expect(utils.isHtml5HistorySupported()).toBeTruthy();
		globals.window.history = null;
		expect(!utils.isHtml5HistorySupported()).toBeTruthy();
	});

	it('tests if a given url is a valid web (http/https) uri', () => {
		expect(utils.isWebUri('tel:+999999999')).toBeFalsy();
		expect(utils.isWebUri('http://localhost:12345')).toBeInstanceOf(Uri);
	});
});
