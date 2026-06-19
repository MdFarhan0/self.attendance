@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package `in`.hridayan.driftly.core.presentation.components.button

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import `in`.hridayan.driftly.R
import `in`.hridayan.driftly.core.common.LocalWeakHaptic
import `in`.hridayan.driftly.core.presentation.components.tooltip.TooltipContent
import `in`.hridayan.driftly.navigation.LocalNavController

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val weakHaptic = LocalWeakHaptic.current
    val navController = LocalNavController.current

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(if (isPressed) 0.9f else 1f, label = "button_scale")

    TooltipContent(stringResource(R.string.back_button)) {
        FilledTonalIconButton(
            onClick = {
                weakHaptic()
                if (onClick != null) {
                    onClick()
                } else {
                    navController.popBackStack()
                }
            },
            interactionSource = interactionSource,
            shapes = IconButtonDefaults.shapes(),
            modifier = Modifier.size(40.dp).scale(scale)
        ) {
            Icon(
                modifier = modifier.size(24.dp),
                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                contentDescription = null
            )
        }
    }
}