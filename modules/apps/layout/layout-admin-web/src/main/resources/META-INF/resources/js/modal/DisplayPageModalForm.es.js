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

import React, {useRef, useEffect, useState, useCallback} from 'react';
import PropTypes from 'prop-types';
import FormField from './FormField.es';

const DisplayPageModalForm = React.forwardRef((props, ref) => {
	const [subtypes, setSubtypes] = useState([]);
	const nameInput = useRef(null);

	useEffect(() => {
		if (nameInput.current) {
			nameInput.current.focus();
		}
	}, []);

	const onChange = useCallback(
		event => {
			const select = event.target;
			const selectedMappingId =
				select.options[select.selectedIndex].value;

			const mappingType = props.mappingTypes.find(
				mappingType => mappingType.id === selectedMappingId
			);

			if (mappingType) {
				setSubtypes(mappingType.subtypes);
			} else {
				setSubtypes([]);
			}
		},
		[props.mappingTypes]
	);

	return (
		<form onSubmit={props.onSubmit} ref={ref}>
			<FormField
				error={props.error && props.error.name}
				id={`${props.namespace}name`}
				name={Liferay.Language.get('name')}
			>
				<input
					className={'form-control'}
					defaultValue={props.displayPageName}
					name={`${props.namespace}name`}
					ref={nameInput}
				/>
			</FormField>

			{Array.isArray(props.mappingTypes) &&
				props.mappingTypes.length > 0 && (
					<fieldset>
						<FormField
							error={props.error && props.error.classNameId}
							id={`${props.namespace}classNameId`}
							name={Liferay.Language.get('content-type')}
						>
							<select
								className="form-control"
								name={`${props.namespace}classNameId`}
								onChange={onChange}
							>
								<option value="">
									{`-- ${Liferay.Language.get(
										'no-selected'
									)} --`}
								</option>
								{props.mappingTypes.map(mappingType => (
									<option
										key={mappingType.id}
										value={mappingType.id}
									>
										{mappingType.label}
									</option>
								))}
							</select>
						</FormField>

						{Array.isArray(subtypes) && subtypes.length > 0 && (
							<FormField
								error={props.error && props.error.classTypeId}
								id={`${props.namespace}classTypeId`}
								name={Liferay.Language.get('subtype')}
							>
								<select
									className="form-control"
									name={`${props.namespace}classTypeId`}
								>
									<option value="">
										{`-- ${Liferay.Language.get(
											'no-selected'
										)} --`}
									</option>
									{subtypes.map(subtype => (
										<option
											key={subtype.id}
											value={subtype.id}
										>
											{subtype.label}
										</option>
									))}
								</select>
							</FormField>
						)}
					</fieldset>
				)}
		</form>
	);
});

DisplayPageModalForm.propTypes = {
	displayPageName: PropTypes.string,
	error: PropTypes.object,
	mappingType: PropTypes.arrayOf(
		PropTypes.shape({
			id: PropTypes.string,
			label: PropTypes.string,
			subtypes: PropTypes.arrayOf(
				PropTypes.shape({
					id: PropTypes.string,
					label: PropTypes.string
				})
			)
		})
	),
	namespace: PropTypes.string.isRequired,
	onSubmit: PropTypes.func.isRequire
};

export {DisplayPageModalForm};
export default DisplayPageModalForm;
