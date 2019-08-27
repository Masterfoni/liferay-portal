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

import React, {useContext, useState} from 'react';
import ClayManagementToolbar from '@clayui/management-toolbar';
import { SearchContext } from '../search-container/SearchContext.es';

export default ({totalCount}) => {
    const {
        dispatch,
		state: {
			query: {keywords}
		}
    } = useContext(SearchContext);

    const [state, setState] = useState({
		asc: true,
		column: 'name'
    });
    
    const FILTERITEMS = [
        {
            key: 'name',
            label: Liferay.Language.get('name'),
            onClick: () => sort(true, 'name')
        },
        {
            key: 'dateCreated',
            label: Liferay.Language.get('create-date'),
            onClick: () => sort(true, 'dateCreated')
        },
        {
            key: 'dateModified',
            label: Liferay.Language.get('modified-date'),
            onClick: () => sort(true, 'dateModified')
        },
    ];
    
    const {asc, column} = state;

    const sort = (asc, column) => {
        dispatch({sort: `${column}:${asc ? 'asc' : 'desc'}`, type: 'SORT'});
        setState({asc, column});
    };
    
    const extractFilterItems = (filterItems) => {
        return filterItems.map(filterItem => {
            return { active: filterItem.key === column, ...filterItem };
        });
    }

  return (
    <>
        <ClayManagementToolbar
            disabled={totalCount == 0 && keywords === ''}
            filterItems={extractFilterItems(FILTERITEMS)}
            onClearButtonClick={() => dispatch({keywords: '', type: 'SEARCH'})}
            onSearchValueChange={searchValue => dispatch({keywords: searchValue.trim(), type: 'SEARCH'})}
            onSortingButtonClick={() => sort(!asc, column)}
            searchValue={keywords}
            showResultsBar={keywords !== ''}
            sortingOrder={asc ? 'asc' : 'desc'}
            totalItems={totalCount}
        />
    </>
  );
}