{
"badges":[
			<#list badges as badge>
				"${badge}"<#if badge_has_next>,</#if>
			</#list>
		 ]
}