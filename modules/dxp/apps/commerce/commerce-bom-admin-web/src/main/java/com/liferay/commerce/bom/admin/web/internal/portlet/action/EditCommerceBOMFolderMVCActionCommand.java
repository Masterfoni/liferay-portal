/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.commerce.bom.admin.web.internal.portlet.action;

import com.liferay.commerce.bom.constants.CommerceBOMPortletKeys;
import com.liferay.commerce.bom.exception.NoSuchBOMFolderException;
import com.liferay.commerce.bom.model.CommerceBOMFolder;
import com.liferay.commerce.bom.service.CommerceBOMFolderService;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alessio Antonio Rendina
 */
@Component(
	enabled = false, immediate = true,
	property = {
		"javax.portlet.name=" + CommerceBOMPortletKeys.COMMERCE_BOM_ADMIN,
		"mvc.command.name=editCommerceBOMFolder"
	},
	service = MVCActionCommand.class
)
public class EditCommerceBOMFolderMVCActionCommand
	extends BaseMVCActionCommand {

	protected CommerceBOMFolder addCommerceBOMFolder(
			ActionRequest actionRequest)
		throws Exception {

		long parentCommerceBOMFolderId = ParamUtil.getLong(
			actionRequest, "parentCommerceBOMFolderId");

		String name = ParamUtil.getString(actionRequest, "name");
		boolean deleteLogo = ParamUtil.getBoolean(actionRequest, "deleteLogo");

		byte[] logoBytes = null;

		long fileEntryId = ParamUtil.getLong(actionRequest, "fileEntryId");

		if (fileEntryId > 0) {
			FileEntry fileEntry = _dlAppLocalService.getFileEntry(fileEntryId);

			logoBytes = FileUtil.getBytes(fileEntry.getContentStream());
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			CommerceBOMFolder.class.getName(), actionRequest);

		return _commerceBOMFolderService.addCommerceBOMFolder(
			serviceContext.getUserId(), parentCommerceBOMFolderId, name,
			!deleteLogo, logoBytes);
	}

	protected void deleteCommerceBOMFolder(ActionRequest actionRequest)
		throws Exception {

		long commerceBOMFolderId = ParamUtil.getLong(
			actionRequest, "commerceBOMFolderId");

		_commerceBOMFolderService.deleteCommerceBOMFolder(commerceBOMFolderId);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD)) {
				CommerceBOMFolder commerceBOMFolder = addCommerceBOMFolder(
					actionRequest);

				String redirect = getSaveAndContinueRedirect(
					actionRequest, commerceBOMFolder);

				JSONObject jsonObject = JSONUtil.put("redirectURL", redirect);

				JSONPortletResponseUtil.writeJSON(
					actionRequest, actionResponse, jsonObject);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteCommerceBOMFolder(actionRequest);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateCommerceBOMFolder(actionRequest);
			}
		}
		catch (Exception exception) {
			if (exception instanceof NoSuchBOMFolderException ||
				exception instanceof PrincipalException) {

				SessionErrors.add(actionRequest, exception.getClass());

				actionResponse.setRenderParameter("mvcPath", "/error.jsp");
			}
			else {
				_log.error(exception, exception);
			}
		}

		hideDefaultSuccessMessage(actionRequest);
	}

	protected String getSaveAndContinueRedirect(
			ActionRequest actionRequest, CommerceBOMFolder commerceBOMFolder)
		throws PortalException {

		PortletURL portletURL = PortletProviderUtil.getPortletURL(
			actionRequest, CommerceBOMFolder.class.getName(),
			PortletProvider.Action.MANAGE);

		portletURL.setParameter(
			"mvcRenderCommandName", "editCommerceBOMFolder");

		portletURL.setParameter(
			"commerceBOMFolderId",
			String.valueOf(commerceBOMFolder.getCommerceBOMFolderId()));

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		portletURL.setParameter("redirect", redirect);

		return portletURL.toString();
	}

	protected CommerceBOMFolder updateCommerceBOMFolder(
			ActionRequest actionRequest)
		throws Exception {

		long commerceBOMFolderId = ParamUtil.getLong(
			actionRequest, "commerceBOMFolderId");

		String name = ParamUtil.getString(actionRequest, "name");
		boolean deleteLogo = ParamUtil.getBoolean(actionRequest, "deleteLogo");

		byte[] logoBytes = null;

		long fileEntryId = ParamUtil.getLong(actionRequest, "fileEntryId");

		if (fileEntryId > 0) {
			FileEntry fileEntry = _dlAppLocalService.getFileEntry(fileEntryId);

			logoBytes = FileUtil.getBytes(fileEntry.getContentStream());
		}

		return _commerceBOMFolderService.updateCommerceBOMFolder(
			commerceBOMFolderId, name, !deleteLogo, logoBytes);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditCommerceBOMFolderMVCActionCommand.class);

	@Reference
	private CommerceBOMFolderService _commerceBOMFolderService;

	@Reference
	private DLAppLocalService _dlAppLocalService;

}