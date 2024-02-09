package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage

@Composable
fun HSCard() {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(4.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {

            val (profileImage, author, description) = createRefs()

            AsyncImage(
                model = "https://fastly.picsum.photos/id/283/200/300.jpg?hmac=HVbRBUPQVx2vypDRbrSdilx6LhDFbU9jsqNdlKR9J9I",
                contentDescription = "픽섬",
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(color = placeHolderColor),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
                    .constrainAs(profileImage) {
                        centerVerticallyTo(parent)
//                        linkTo(parent.top,parent.bottom)
//                        top.linkTo(parent.top)
//                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start, margin = 8.dp)
                    }
            )

            Text(
                text = "abcd",
                modifier = Modifier.constrainAs(author) {
                    linkTo(profileImage.end,parent.end , startMargin = 8.dp , endMargin = 8.dp)
                    width = Dimension.fillToConstraints
                }
            )
            Text(
                text = "efgggggadadadadadadadadadadadadadadadadadadadadadadadad",
                modifier = Modifier.constrainAs(description) {
                    linkTo(profileImage.end,parent.end, startMargin = 8.dp , endMargin = 8.dp)
                    /** 텍스트가 지정한 제약의 범위(ex. width)를 넘어가지 않게 옵션을 준다. */
                    width = Dimension.fillToConstraints
                }
            )

            /** Chain 으로 연결이 되면 해당 방향의 margin을 컴포넌트에 직접 줄 수 없다. (꺼진다고 생각하면됨) */
            /** 즉 VerticalChain 에서 top, bottom 에 margin 을 주려면 chain 에 margin 을 줘야함. */
            val chain = createVerticalChain(author, description, chainStyle = ChainStyle.Packed)
            constrain(chain) {
                top.linkTo(parent.top , margin = 8.dp)
                bottom.linkTo(parent.bottom , margin = 8.dp)
            }
        }
    }
}