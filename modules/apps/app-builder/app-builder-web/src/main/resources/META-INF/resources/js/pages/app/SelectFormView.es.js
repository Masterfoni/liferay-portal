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

import classNames from 'classnames';
import moment from 'moment';
import React, {useContext, useEffect, useState} from 'react';
import {ClayRadio, ClayRadioGroup} from '@clayui/form';
import {AppContext} from './AppContext.es';
import CreationMultiStep from './CreationMultiStep.es';
import ClayTable from '@clayui/table';
import {getItem} from '../../utils/client.es';
import Button from '../../components/button/Button.es';
import EditAppHeader from './EditAppHeader.es';

const {Body, Cell, Head, Row} = ClayTable;

export default ({
	history,
	match: {
		params: {dataDefinitionId}
	}
}) => {
	const {app, setApp} = useContext(AppContext);
    const [formViews, setFormViews] = useState([]);
    const [selectedFormViewId, setSelectedFormViewId] = useState({});

	useEffect(() => {
		const getFormViews = getItem(
			`/o/data-engine/v1.0/data-definitions/${dataDefinitionId}/data-layouts`
		);

		getFormViews.then(response => {
            setFormViews(response.items);
            setSelectedFormViewId(app.dataLayoutId);
		});
	}, [dataDefinitionId, app.dataLayoutId]);

	const handleSelectedFormViewChange = newFormView => {
        setSelectedFormViewId(newFormView.id);
        setApp({
            ...app,
            dataLayoutId: newFormView.id
        });
	};

	const handleCancel = () => {
		history.push(`/custom-object/${dataDefinitionId}/apps`);
	};

	const handleForwardNavigation = () => {
		history.push(`/custom-object/${dataDefinitionId}/apps/add/table-view`);
	};

	return (
		<>
			<div className="container-fluid container-fluid-max-lg mt-4">
				<div className="card card-root shadowless-card">
					<EditAppHeader />

					<div className="card-body pt-0 pr-0 pl-0">
						<h4 className="card-divider mb-4"></h4>

						<div className="autofit-row">
							<div className="col-md-12">
								<CreationMultiStep
									currentStep={1}
									totalSteps={3}
								/>
							</div>
						</div>

						<div className="autofit-row pl-4 pr-4 mb-4">
							<div className="autofit-col-expand">
								<h2>
									{Liferay.Language.get('select-a-form-view')}
								</h2>
							</div>
						</div>

						<div className="autofit-row pl-4 pr-4 mb-4">
							<div className="autofit-col-expand">
								<div className="input-group">
									<div className="input-group-item">
										<input
											aria-label={Liferay.Language.get(
												'search-for'
											)}
											className="form-control input-group-inset input-group-inset-after"
											disabled={true}
											placeholder={Liferay.Language.get(
												'search-for'
											)}
											type="text"
										/>

										<div className="input-group-inset-item input-group-inset-item-after">
											<Button
												disabled={true}
												displayType="unstyled"
												symbol="search"
											/>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div className="autofit-row pl-4 pr-4 scrollable-container">
							<div className="autofit-col-expand">
								<table
									className={
										'table table-responsive table-autofit table-hover table-heading-nowrap table-nowrap'
									}
								>
									<Head>
										<Row>
											<Cell expanded={true} headingCell>
												{Liferay.Language.get('name')}
											</Cell>
											<Cell headingCell>
												{Liferay.Language.get(
													'create-date'
												)}
											</Cell>
											<Cell headingCell>
												{Liferay.Language.get(
													'modified-date'
												)}
											</Cell>
											<Cell headingCell></Cell>
										</Row>
									</Head>

									<Body>
										{formViews.map((formView, index) => {
											return (
												<Row
													className={classNames(
														'selectable-row',
														{
															'selectable-active':
                                                                formView.id ===
                                                                selectedFormViewId
														}
													)}
													key={index}
													onClick={() =>
														handleSelectedFormViewChange(
															formView
														)
													}
												>
													<Cell align="left">
														{formView.name.en_US}
													</Cell>
													<Cell>
														{moment(
															formView.dateCreated
														).fromNow()}
													</Cell>
													<Cell>
														{moment(
															formView.dateModified
														).fromNow()}
													</Cell>
													<Cell align={'right'}>
														<ClayRadioGroup
															inline
															onSelectedValueChange={
																handleSelectedFormViewChange
															}
															selectedValue={
                                                                selectedFormViewId
															}
														>
															<ClayRadio
																value={formView.id}
															></ClayRadio>
														</ClayRadioGroup>
													</Cell>
												</Row>
											);
										})}
									</Body>
								</table>
							</div>
						</div>

						<h4 className="card-divider"></h4>

						<div className="card-footer bg-transparent">
							<div className="autofit-row">
								<div className="col-md-4">
									<Button
										displayType="secondary"
										onClick={handleCancel}
									>
										{Liferay.Language.get('cancel')}
									</Button>
								</div>
								<div className="col-md-4 offset-md-4 text-right">
									<Button
										displayType="primary"
										onClick={handleForwardNavigation}
									>
										{Liferay.Language.get('next')}
									</Button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</>
	);
};
